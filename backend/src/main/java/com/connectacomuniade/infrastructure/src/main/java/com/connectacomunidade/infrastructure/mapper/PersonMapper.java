package com.connectacomunidade.infrastructure.mapper;

import com.connectacomunidade.domain.person.Person;
import com.connectacomunidade.domain.valueobjects.Email;
import com.connectacomunidade.domain.valueobjects.IdentificationNumber;
import com.connectacomunidade.domain.valueobjects.PhoneNumber;
import com.connectacomunidade.infrastructure.persistence.jpa.person.PersonJpaEntity;

public class PersonMapper {

    public PersonJpaEntity personToPersonJpaEntity(Person person) {
        return new PersonJpaEntity(
                person.getRef().getValue(),
                person.getName(),
                person.getEmail().getValue(),
                person.getIdentificationNumber().getValue(),
                person.getBirthdate(),
                person.getPhoneNumber().getValue()
        );
    }

    public Person personJpaEntityToPerson(PersonJpaEntity personJpaEntity) {
        return Person.of(
                personJpaEntity.getRef(),
                personJpaEntity.getName(),
                Email.of(personJpaEntity.getEmail()),
                IdentificationNumber.create(personJpaEntity.getIdentificationNumber()),
                personJpaEntity.getBirthdate(),
                PhoneNumber.of(personJpaEntity.getPhoneNumber())
        );
    }
}
