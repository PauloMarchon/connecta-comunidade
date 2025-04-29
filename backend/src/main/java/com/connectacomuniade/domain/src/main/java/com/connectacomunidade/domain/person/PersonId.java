package com.connectacomunidade.domain.person;

import com.connectacomunidade.domain.BaseId;

import java.util.Objects;
import java.util.UUID;

public class PersonId extends BaseId<UUID> {

    private PersonId(UUID value) {
        super(value);
        Objects.requireNonNull(value);
    }

    public static PersonId of(UUID value){
        return new PersonId(value);
    }

    public static  PersonId newId() {
        return new PersonId(UUID.randomUUID());
    }
}
