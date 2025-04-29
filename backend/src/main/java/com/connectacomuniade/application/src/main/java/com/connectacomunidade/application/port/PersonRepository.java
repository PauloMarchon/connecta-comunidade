package com.connectacomunidade.application.port;

import com.connectacomunidade.domain.person.Person;
import com.connectacomunidade.domain.person.PersonId;
import com.connectacomunidade.domain.valueobjects.Email;
import com.connectacomunidade.domain.valueobjects.IdentificationNumber;
import com.connectacomunidade.domain.valueobjects.PhoneNumber;

import java.util.List;
import java.util.Optional;

public interface PersonRepository {
    Person save(Person person);

    List<Person> findAll();

    Optional<Person> findById(PersonId personId);
    Optional<Person> findByEmail(Email email);
    Optional<Person> findByIdentificationNumber(IdentificationNumber identificationNumber);
    Optional<Person> findByPhoneNumber(PhoneNumber phoneNumber);

    boolean existsById(PersonId personId);
    boolean existsByEmail(Email email);
    boolean existsByIdentificationNumber(IdentificationNumber identificationNumber);
    boolean existsByPhoneNumber(PhoneNumber phoneNumber);
}
