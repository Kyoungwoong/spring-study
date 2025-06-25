package com.example.spring_study.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    // 500 Server Error
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Admin Server Error"),
    FAIL_TO_EXECUTE_TASK(HttpStatus.INTERNAL_SERVER_ERROR, "Cannot execute task"),
    FILE_UPLOAD_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to upload file"),
    FILE_DOWNLOAD_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to download file"),
    MEMBER_DATA_PROCESSING_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to retrieve member details."),
    MEMBER_SEARCH_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to search member."),
    JSON_PROCESSING_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to serialize"),

    // 400 Bad Request
    INVALID_CREDENTIALS(HttpStatus.BAD_REQUEST, "Invalid email or password"),
    INVALID_FILE_EXTENSION(HttpStatus.BAD_REQUEST, "Invalid File Extension"),
    USER_PASSWORD_NOT_MATCH(HttpStatus.BAD_REQUEST, "Password does not match"),
    INVALID_SURVEY_SCORE(HttpStatus.BAD_REQUEST, "Invalid Survey score"),
    INVALID_KEYWORD(HttpStatus.BAD_REQUEST, "Invalid Keyword"),

    // 401 Unauthorized,
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "Unauthorized"),
    SESSION_EXPIRED(HttpStatus.UNAUTHORIZED, "Session has expired. Please log in again."),
    INVALID_TOKEN(HttpStatus.UNAUTHORIZED, "Invalid Token"),

    // 403 Forbidden
    ACCOUNT_DISABLED(HttpStatus.FORBIDDEN, "Account disabled"),
    ACCOUNT_LOCKED(HttpStatus.FORBIDDEN, "Account locked"),
    NO_PERMISSION(HttpStatus.FORBIDDEN, "This account has no permission"),
    INVALID_ROOM_PASSWORD(HttpStatus.FORBIDDEN, "Does not matched password"),

    // 404 Not Found
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "User not found"),
    ADMIN_NOT_FOUND(HttpStatus.NOT_FOUND, "Admin not found"),
    ROOM_NOT_FOUND(HttpStatus.NOT_FOUND, "Room not found"),
    ROOM_MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "Room Member not found"),

    // 409 Conflict,
    USER_ALREADY_EXISTS(HttpStatus.CONFLICT, "User with this email already exists"),
    CONCURRENT_CONNECTION(HttpStatus.CONFLICT, "User Already connection"),
    ROOM_ALREADY_EXISTS(HttpStatus.CONFLICT, "Room with this id already exists");

    private final HttpStatus status;
    private final String msg;

    ErrorCode(HttpStatus status, String msg) {
        this.status = status;
        this.msg = msg;
    }
}
