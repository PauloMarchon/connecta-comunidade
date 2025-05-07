package com.connectacomunidade.application.usecases.person.retrieve.email;

import com.connectacomunidade.domain.person.Person;

public record FindPersonByEmailOutput(
        Person person
) {
}
