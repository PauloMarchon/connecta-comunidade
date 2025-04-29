package com.connectacomunidade.application.port.out;

import com.connectacomunidade.domain.valueobjects.PhoneNumber;

public interface PhoneNumberUniquenessChecker {
    boolean isPhoneNumberAlreadyUsed(PhoneNumber phoneNumber);
}
