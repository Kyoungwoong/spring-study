package com.example.spring_study.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * {@code @LogExecutionTime} 어노테이션은 메서드의 실행 시간을 측정하고 로그로 출력하는 데 사용됩니다.
 * 이 어노테이션은 메서드에만 적용됩니다.
 */
@Retention(RetentionPolicy.RUNTIME)  // 이 어노테이션은 런타임 동안 유지됩니다.
@Target(ElementType.METHOD)         // 이 어노테이션은 메서드에만 적용됩니다.
public @interface LogExecutionTime {
}
