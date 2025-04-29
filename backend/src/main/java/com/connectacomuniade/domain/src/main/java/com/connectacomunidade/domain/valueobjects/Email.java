package com.connectacomunidade.domain.valueobjects;

public class Email {
    private final String value;

    private Email(String value) {
        if (!isValid(value))
            throw new IllegalArgumentException();

        this.value = value;
    }

    public static Email of(final String email) {
        return new Email(email);
    }

    private static boolean isValid(final String email) {
        return true;
    }

    public String getValue() {
        return value;
    }
}
