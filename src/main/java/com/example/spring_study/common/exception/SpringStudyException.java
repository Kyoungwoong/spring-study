package com.example.spring_study.common.exception;

import lombok.Getter;

@Getter
public class SpringStudyException extends RuntimeException {

    private final ErrorCode errorCode;

    /**
     * @param errorCode ErrorCode에 정의된 메시지 반환
     */
    public SpringStudyException(ErrorCode errorCode) {
        super(errorCode.getMsg());
        this.errorCode = errorCode;
    }

    /**
     * @param message 정의되지 않은 예외 처리
     */
    public SpringStudyException(String message) {
        super(message);
        this.errorCode = ErrorCode.INTERNAL_SERVER_ERROR;
    }
}
