package com.example.spring_study.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * {@code @CustomAnnotation}은 메타 어노테이션 {@code @Retention}과 {@code @Target}을 사용한 예제입니다.
 * 이 어노테이션은 클래스에만 적용될 수 있으며, 런타임 동안 유지됩니다.
 */
@Retention(RetentionPolicy.RUNTIME)  // 이 어노테이션은 런타임까지 유지됩니다.
@Target(ElementType.TYPE)           // 이 어노테이션은 클래스, 인터페이스 또는 열거형에만 적용됩니다.
@interface CustomAnnotation {
    String value() default "Default Value";
}

@CustomAnnotation(value = "Hello, Metaannotations!")  // CustomAnnotation을 클래스에 적용
public class MetaAnnotation {
    public void display() {
        System.out.println("Sample class method.");
    }
}
