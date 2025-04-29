package com.connectacomunidade.domain.valueobjects;

public class CPF implements IdentificationNumber{
    private final String value;

    private CPF(String value) {
        if (!isValid(value))
            throw new IllegalArgumentException();

        this.value = value;
    }

    public static CPF of(final String cpf) {
        return new CPF(cpf);
    }

    private static boolean isValid(final String cpf) {
        return true;
    }

    @Override
    public String getValue() {
        return this.value;
    }
}
