package com.connectacomunidade.domain.valueobjects;

import java.util.Objects;

public class PhoneNumber {
    private final String value;

    private PhoneNumber(String value) {
        if (!isValid(value))
            throw new IllegalArgumentException();

        this.value = value;
    }

    public static PhoneNumber of(final String phoneNumber) {
        return new PhoneNumber(phoneNumber);
    }

    private static boolean isValid(final String phoneNumber) {
        return true;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumber that = (PhoneNumber) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
