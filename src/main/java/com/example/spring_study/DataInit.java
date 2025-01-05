package com.example.spring_study;

import com.example.spring_study.domain.ChatRoom;
import com.example.spring_study.domain.FilterData;
import com.example.spring_study.repository.ChatRoomRepository;
import com.example.spring_study.repository.FilterDataRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataInit implements CommandLineRunner {

    private final ChatRoomRepository repository;
    private final FilterDataRepository filterDataRepository;

    @Override
    public void run(String... args) throws Exception {

        ChatRoom chatRoom1 = new ChatRoom("맨유 VS 토트넘");
        ChatRoom chatRoom2 = new ChatRoom("아스날 VS 맨시티");
        ChatRoom chatRoom3 = new ChatRoom("첼시 VS 리버풀");

        repository.save(chatRoom1);
        repository.save(chatRoom2);
        repository.save(chatRoom3);

        FilterData filterData1 = new FilterData("닭트넘");
        FilterData filterData2 = new FilterData("맹구");

        filterDataRepository.save(filterData1);
        filterDataRepository.save(filterData2);

        log.info("데이터 초기화 완료");
    }
}
