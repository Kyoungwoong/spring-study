package com.example.spring_study.annotation;

public class StandardAnnotation {

    /**
     * {@code @Override} 어노테이션은 자식 클래스에서 부모 클래스의 메서드를 오버라이드할 때 사용됩니다.
     * 부모 클래스의 메서드와 일치하지 않으면 컴파일 에러가 발생합니다.
     */
    class Parent {
        void run() {}
    }

    class Child extends Parent {
        @Override // 컴파일 에러! 잘못된 오버라이드
        void run() {}
    }


    /**
     * {@code @Deprecated} 어노테이션은 해당 메서드, 클래스, 또는 필드가 더 이상 사용되지 않음을 나타냅니다.
     * 이 어노테이션이 붙은 요소는 향후 버전에서 제거될 수 있으므로, 사용을 피해야 합니다.
     */
    @Deprecated
    public int getInt() {
        return 1;
    }
}
