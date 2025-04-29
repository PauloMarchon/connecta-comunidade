package com.connectacomunidade.domain.person;

import com.connectacomunidade.domain.exception.NotificationException;
import com.connectacomunidade.domain.notification.NotificationContext;
import com.connectacomunidade.domain.validation.ValidationHandler;
import com.connectacomunidade.domain.valueobjects.Email;
import com.connectacomunidade.domain.valueobjects.IdentificationNumber;
import com.connectacomunidade.domain.valueobjects.PhoneNumber;

import java.time.LocalDate;

public class Person {
    private final PersonId ref;
    private String name;
    private Email email;
    private IdentificationNumber identificationNumber;
    private LocalDate birthdate;
    private PhoneNumber phoneNumber;

    private Person(
            PersonId ref,
            String name,
            Email email,
            IdentificationNumber identificationNumber,
            LocalDate birthdate,
            PhoneNumber phoneNumber) {
        this.ref = ref;
        this.name = name;
        this.email = email;
        this.identificationNumber = identificationNumber;
        this.birthdate = birthdate;
        this.phoneNumber = phoneNumber;

        selfValidate();
    }

    public void selfValidate() {
        final var notificationContext = NotificationContext.create();
        validate(notificationContext);

        if (notificationContext.hasNotification())
            throw new NotificationException("", notificationContext);
    }

    public void validate(ValidationHandler handler) {
        new PersonValidator(this, handler).validate();
    }

    public static Person of(
            String nome,
            Email email,
            IdentificationNumber identificationNumber,
            LocalDate birthdate,
            PhoneNumber phoneNumber
    ) {
        return new Person(
                PersonId.newId(), nome, email, identificationNumber, birthdate, phoneNumber
        );
    }

    public PersonId getRef() {
        return ref;
    }

    public String getName() {
        return name;
    }

    public Email getEmail() {
        return email;
    }

    public IdentificationNumber getIdentificationNumber() {
        return identificationNumber;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}
