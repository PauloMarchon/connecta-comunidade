package com.connectacomunidade.domain.valueobjects;

import com.connectacomunidade.domain.exception.InvalidValueException;

public interface IdentificationNumber {
    String getValue();

    static IdentificationNumber create(String number) {
        String cleanedNumber = number.replaceAll("\\D", "");

        if (cleanedNumber.matches("\\d{11}")) {
            return CPF.of(cleanedNumber);
        } else if (cleanedNumber.matches("\\d{14}")) {
            return CNPJ.of(cleanedNumber);
        } else {
            throw new InvalidValueException("Invalid identification number");
        }
    }
}
