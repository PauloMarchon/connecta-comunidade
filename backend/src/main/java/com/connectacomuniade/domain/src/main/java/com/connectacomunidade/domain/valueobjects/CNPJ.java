package com.connectacomunidade.domain.valueobjects;

import com.connectacomunidade.domain.exception.InvalidValueException;

import java.util.Objects;

public class CNPJ implements IdentificationNumber{
    private final String value;

    private CNPJ(String value) {
        if (!isValid(value))
            throw new InvalidValueException("Invalid CNPJ number");

        this.value = value;
    }

    public static CNPJ of(final String cnpj) {
        return new CNPJ(cnpj);
    }

    private static boolean isValid(final String cnpj) {
        return cnpj != null && !cnpj.trim().isEmpty();
    }

    @Override
    public String getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CNPJ cnpj = (CNPJ) o;
        return Objects.equals(value, cnpj.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
