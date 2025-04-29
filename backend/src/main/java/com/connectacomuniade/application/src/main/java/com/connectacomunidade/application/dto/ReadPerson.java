package com.connectacomunidade.application.dto;

import com.connectacomunidade.domain.person.Person;

import java.time.LocalDate;

public record ReadPerson(
        String name,
        String email,
        LocalDate birthdate,
        String phoneNumber
) {
    public static ReadPerson fromPerson(Person person) {
        return new ReadPerson(
                person.getName(),
                person.getEmail().getValue(),
                person.getBirthdate(),
                person.getPhoneNumber().getValue()
        );
    }
}
