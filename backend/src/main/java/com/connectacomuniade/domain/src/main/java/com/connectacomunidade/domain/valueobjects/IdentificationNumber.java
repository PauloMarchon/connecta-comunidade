package com.connectacomunidade.domain.valueobjects;

public interface IdentificationNumber {
    String getValue();

    static IdentificationNumber create(String numero) {
        String cleaned = numero.replaceAll("\\D", "");

        if (cleaned.matches("\\d{11}")) {
            return CPF.of(cleaned);
        } else if (cleaned.matches("\\d{14}")) {
            return CNPJ.of(cleaned);
        } else {
            throw new IllegalArgumentException("Número de identificação inválido.");
        }
    }
}
