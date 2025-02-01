package com.pragma.franquicias.infrastructure.exceptionhandler;

public class ExceptionResponse {

    private final String message;

    ExceptionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}