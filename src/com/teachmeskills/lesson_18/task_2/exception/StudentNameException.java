package com.teachmeskills.lesson_18.task_2.exception;

public class StudentNameException extends Exception {
    public enum ErrorType {
        INVALID_INPUT,
        EMPTY_NAME_LIST,
        NAME_NOT_FOUND
    }

    private final ErrorType errorType;

    public StudentNameException(String message, ErrorType errorType) {
        super(message);
        this.errorType = errorType;
    }

    public ErrorType getErrorType() {
        return errorType;
    }

    public String getDetailedMessage() {
        return String.format("Error [%s]: %s", errorType.name(), getMessage());
    }
}