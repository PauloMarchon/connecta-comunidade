package com.connectacomunidade.domain.valueobjects;

public class CNPJ implements IdentificationNumber{
    private final String value;

    private CNPJ(String value) {
        this.value = value;
    }

    public static CNPJ of(final String cnpj) {
        return new CNPJ(cnpj);
    }

    private static boolean isValid(final String cnpj) {
        return true;
    }

    @Override
    public String getValue() {
        return this.value;
    }
}
