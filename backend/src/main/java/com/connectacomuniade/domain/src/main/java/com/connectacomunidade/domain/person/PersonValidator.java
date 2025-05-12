package com.connectacomunidade.domain.person;

import com.connectacomunidade.domain.notification.Notification;
import com.connectacomunidade.domain.validation.ValidationHandler;
import com.connectacomunidade.domain.validation.Validator;

import java.time.LocalDate;

public class PersonValidator extends Validator {
    private final Person person;

    protected PersonValidator(final Person person, ValidationHandler handler) {
        super(handler);
        this.person = person;
    }

    @Override
    public void validate() {
        if (person.getName().isBlank())
            getHandler().addNotification(new Notification("Invalid username"));

        if (person.getBirthdate().isAfter(LocalDate.now()))
            getHandler().addNotification(new Notification("Invalid birthdate"));
    }
}
