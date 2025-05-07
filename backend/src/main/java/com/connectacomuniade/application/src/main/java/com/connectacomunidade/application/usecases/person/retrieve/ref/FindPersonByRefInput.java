package com.connectacomunidade.application.usecases.person.retrieve.ref;

import java.util.UUID;

public record FindPersonByRefInput(
        UUID ref
) {
}
