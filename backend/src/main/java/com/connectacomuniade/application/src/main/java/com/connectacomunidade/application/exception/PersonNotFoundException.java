package com.connectacomunidade.application.exception;

public class PersonNotFoundException extends RuntimeException {
    public PersonNotFoundException(String message) {
        super(message);
    }
}
