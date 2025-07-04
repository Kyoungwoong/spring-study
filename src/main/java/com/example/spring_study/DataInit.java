package com.example.spring_study;

import com.example.spring_study.domain.ChatRoom;
import com.example.spring_study.domain.FilterData;
import com.example.spring_study.domain.Member;
import com.example.spring_study.domain.MemberRole;
import com.example.spring_study.repository.ChatRoomRepository;
import com.example.spring_study.repository.FilterDataRepository;
import com.example.spring_study.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataInit implements CommandLineRunner {

    private final ChatRoomRepository repository;
    private final FilterDataRepository filterDataRepository;

    private final UserRepository userRepository;

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

        Member member1 = new Member("user1", "user1@example.com", "$2a$10$w1J3fLM6/0R2QOZJGhABbu8Sh2Cz99R8YjCHvlxt8NkbBpQEF2R1e"); // 123123a
        Member member2 = new Member("user2",  "user2@example.com", "$2a$10$w1J3fLM6/0R2QOZJGhABbu8Sh2Cz99R8YjCHvlxt8NkbBpQEF2R1e", MemberRole.ADMIN);

        userRepository.save(member1);
        userRepository.save(member2);

        log.info("데이터 초기화 완료");
    }
}
