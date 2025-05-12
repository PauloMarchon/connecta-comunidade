package com.connectacomunidade.domain.valueobjects;

import com.connectacomunidade.domain.exception.InvalidValueException;

import java.util.Objects;

public class Email {
    private final String value;

    private Email(String value) {
        if (!isValid(value))
            throw new InvalidValueException("The email provided is invalid");

        this.value = value;
    }

    public static Email of(final String email) {
        return new Email(email);
    }

    private static boolean isValid(final String email) {
        return email != null && !email.trim().isEmpty();
        //TODO
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return Objects.equals(value, email.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
