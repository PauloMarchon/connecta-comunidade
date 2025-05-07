package com.connectacomunidade.application.usecases.person.retrieve.ref;

import com.connectacomunidade.domain.person.Person;

public record FindPersonByRefOutput(
        Person person
) {
}
