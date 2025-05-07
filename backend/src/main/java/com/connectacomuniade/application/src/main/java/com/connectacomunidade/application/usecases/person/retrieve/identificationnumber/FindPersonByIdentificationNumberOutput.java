package com.connectacomunidade.application.usecases.person.retrieve.identificationnumber;

import com.connectacomunidade.domain.person.Person;

public record FindPersonByIdentificationNumberOutput(
        Person person
) {
}
