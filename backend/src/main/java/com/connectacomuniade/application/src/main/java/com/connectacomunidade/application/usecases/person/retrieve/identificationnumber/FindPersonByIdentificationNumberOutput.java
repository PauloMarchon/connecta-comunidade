package com.connectacomunidade.application.usecases.person.retrieve.identificationnumber;

import com.connectacomunidade.application.dto.ReadPerson;

public record FindPersonByIdentificationNumberOutput(
        ReadPerson readPerson
) {
}
