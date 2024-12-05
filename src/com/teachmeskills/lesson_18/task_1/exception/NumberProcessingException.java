package com.teachmeskills.lesson_18.task_1.exception;

public class NumberProcessingException extends RuntimeException {
    public enum ErrorType {
        EMPTY_COLLECTION,
        NULL_INPUT,
        CALCULATION_ERROR
    }

    private final ErrorType errorType;

    public NumberProcessingException(String message, ErrorType errorType) {
        super(message);
        this.errorType = errorType;
    }

    public ErrorType getErrorType() {
        return errorType;
    }

    public String getDetailedMessage() {
        return String.format("Error [%s]: %s", errorType.name(), getMessage());
    }

    public static void validateInput(Object input) throws NumberProcessingException {
        if (input == null) {
            throw new NumberProcessingException(
                    "Input cannot be null",
                    ErrorType.NULL_INPUT
            );
        }
    }

    public static void validateCollection(java.util.Collection<?> collection) throws NumberProcessingException {
        validateInput(collection);
        if (collection.isEmpty()) {
            throw new NumberProcessingException(
                    "Collection cannot be empty",
                    ErrorType.EMPTY_COLLECTION
            );
        }
    }
}