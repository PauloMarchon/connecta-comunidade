package com.connectacomunidade.domain.valueobjects;

import com.connectacomunidade.domain.exception.InvalidValueException;

import java.util.Objects;

public class CPF implements IdentificationNumber{
    private final String value;

    private CPF(String value) {
        if (!isValid(value))
            throw new InvalidValueException("Invalid CPF number");

        this.value = value;
    }

    public static CPF of(final String cpf) {
        return new CPF(cpf);
    }

    private static boolean isValid(final String cpf) {
        return cpf != null && !cpf.trim().isEmpty();
    }

    @Override
    public String getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CPF cpf = (CPF) o;
        return Objects.equals(value, cpf.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
