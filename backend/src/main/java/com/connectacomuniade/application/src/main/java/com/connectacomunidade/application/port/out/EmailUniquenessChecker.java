package com.connectacomunidade.application.port.out;

import com.connectacomunidade.domain.valueobjects.Email;

public interface EmailUniquenessChecker {
    boolean isEmailAlreadyUsed(Email email);
}
