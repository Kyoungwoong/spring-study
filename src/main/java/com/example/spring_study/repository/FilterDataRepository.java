package com.example.spring_study.repository;

import com.example.spring_study.domain.FilterData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilterDataRepository extends JpaRepository<FilterData, Long> {

    boolean existsByWord(String value);

    String deleteByWord(String word);
}

