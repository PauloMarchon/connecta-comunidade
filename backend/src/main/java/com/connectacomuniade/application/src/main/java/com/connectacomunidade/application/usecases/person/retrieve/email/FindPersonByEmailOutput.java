package com.connectacomunidade.application.usecases.person.retrieve.email;

import com.connectacomunidade.application.dto.ReadPerson;

public record FindPersonByEmailOutput(
        ReadPerson readPerson
) {
}
