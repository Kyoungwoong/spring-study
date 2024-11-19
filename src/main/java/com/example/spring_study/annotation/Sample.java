package com.example.spring_study.annotation;

import com.example.spring_study.annotation.LogExecutionTime;

public class Sample {

    /**
     * 이 메서드는 실행 시간을 측정할 대상입니다.
     * {@code @LogExecutionTime} 어노테이션을 통해 실행 시간을 로깅합니다.
     */
    @LogExecutionTime
    public void performTask() {
        try {
            // 임의의 작업 (2초 지연)
            Thread.sleep(2000);
            System.out.println("Task performed.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
