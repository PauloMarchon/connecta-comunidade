package com.connectacomunidade.application.port.out;

import com.connectacomunidade.domain.valueobjects.IdentificationNumber;

public interface IdentificationNumberUniquenessChecker {
    boolean isIdentificationNumberAlreadyUsed(IdentificationNumber identificationNumber);
}
