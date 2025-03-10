package com.example.spring_study.service;

import com.example.spring_study.domain.Chat;
import com.example.spring_study.domain.ChatRoom;
import com.example.spring_study.domain.FilterData;
import com.example.spring_study.repository.ChatRepository;
import com.example.spring_study.repository.ChatRoomRepository;
import com.example.spring_study.repository.FilterDataRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatRoomRepository roomRepository;
    private final ChatRepository chatRepository;
    private final FilterDataRepository filterDataRepository;

    private List<String> filteredWords;
    private Map<String, Pattern> filterPatterns = new HashMap<>();
    private final String[] delimiters = {" ", ",", ".", "!", "?", "@", "1"}; // 구분자 리스트
    private final String substituteValue = "*"; // 치환할 문자
    private String delimiterPattern = null;

    @EventListener(ApplicationReadyEvent.class)
    public void loadFilteredWords() {
        log.info("데이터 가져오기");
        filteredWords = filterDataRepository.findAll()
                .stream()
                .map(FilterData::getWord)
                .collect(Collectors.toList());

        delimiterPattern = buildDelimiterPattern();
        compileBadWordPatterns();
    }

    private void compileBadWordPatterns() {
        filterPatterns.clear();

        for (String word : filteredWords) {
            addPatterns(word);
        }
    }

    private String buildDelimiterPattern() {
        StringBuilder delimiterBuilder = new StringBuilder("[");

        for (String delimiter : delimiters) {
            delimiterBuilder.append(Pattern.quote(delimiter)); // 구분자를 패턴으로 변환
        }
        delimiterBuilder.append("]*"); // 모든 구분자를 포함할 수 있도록 패턴 종료

        return delimiterBuilder.toString();
    }

    private void addPatterns(String word) {
        if (filterPatterns.containsKey(word)) {
            return;
        }

        String[] chars = word.split("");
        String regexPattern = String.join(delimiterPattern, chars);

        filterPatterns.put(word, Pattern.compile(regexPattern, Pattern.CASE_INSENSITIVE));
    }

    private void deletePattern(String word) {
        if (filterPatterns.containsKey(word)) {
            filterPatterns.remove(word);
            log.info("패턴 삭제 완료: {}", word);
        } else {
            log.warn("삭제하려는 단어가 존재하지 않습니다: {}", word);
        }
    }

    // 필터 데이터 추가 (캐시 업데이트 포함)
    public void addFilteredWord(String word) {
        FilterData newFilterData = new FilterData(word);

        filterDataRepository.save(newFilterData);
        filteredWords.add(word);
        addPatterns(word);
    }

    // 필터 데이터 삭제 (캐시 업데이트 포함)
    public void removeFilteredWord(String word) {
        filterDataRepository.deleteByWord(word);
        filteredWords.remove(word);
        deletePattern(word);
    }

    public List<ChatRoom> findAllRoom() {
        return roomRepository.findAll();
    }

    public ChatRoom findRoomById(Long id) {
        return roomRepository.findById(id).orElseThrow();
    }

    public ChatRoom createRoom(String name) {
        return roomRepository.save(ChatRoom.createRoom(name));
    }

    public Chat createChat(Long roomId, String sender, String senderEmail, String message) {
        ChatRoom room = roomRepository.findById(roomId).orElseThrow();  // 방 찾기 -> 없는 방일 경우 여기서 예외처리

        Chat chat = Chat.createChat(roomId, sender, senderEmail, filterValue(message));

        return chatRepository.save(chat);
    }

    private String filterValue(String message) {
        String result = message;

        for (Map.Entry<String, Pattern> entry : filterPatterns.entrySet()) {
            Pattern pattern = entry.getValue();
            String badWord = entry.getKey();

            result = pattern.matcher(result).replaceAll(matchedWord ->
                    substituteValue.repeat(matchedWord.group().length()));
        }

        return result;
    }


    // 채팅방 채팅내용 불러오기
    public List<Chat> findAllChatByRoomId(Long roomId) {
        return chatRepository.findAllByRoomId(roomId);
    }

    public ChatRoom createChatRoom(String roomName) {
        ChatRoom newRoom = ChatRoom.builder()
                .name(roomName)
                .build();

        roomRepository.save(newRoom); // DB에 저장
        return newRoom;
    }
}