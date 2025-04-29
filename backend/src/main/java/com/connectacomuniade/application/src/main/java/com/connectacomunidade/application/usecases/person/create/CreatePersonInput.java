package com.connectacomunidade.application.usecases.person.create;

import java.time.LocalDate;

public record CreatePersonInput(
        String name,
        String email,
        String identificationNumber,
        LocalDate birthdate,
        String phoneNumber
) {
}
