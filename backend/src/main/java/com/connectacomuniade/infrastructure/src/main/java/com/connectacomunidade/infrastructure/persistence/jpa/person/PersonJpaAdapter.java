package com.connectacomunidade.infrastructure.persistence.jpa.person;

import com.connectacomunidade.application.port.PersonRepository;
import com.connectacomunidade.domain.person.Person;
import com.connectacomunidade.domain.person.PersonId;
import com.connectacomunidade.domain.valueobjects.Email;
import com.connectacomunidade.domain.valueobjects.IdentificationNumber;
import com.connectacomunidade.domain.valueobjects.PhoneNumber;
import com.connectacomunidade.infrastructure.mapper.PersonMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class PersonJpaAdapter implements PersonRepository {
    private final PersonJpaRepository personJpaRepository;
    private final PersonMapper personMapper;

    public PersonJpaAdapter(PersonJpaRepository personJpaRepository, PersonMapper personMapper) {
        this.personJpaRepository = personJpaRepository;
        this.personMapper = personMapper;
    }

    @Override
    @Transactional
    public Person save(Person person) {
        PersonJpaEntity entity = personMapper.personToPersonJpaEntity(person);

        PersonJpaEntity savedEntity = personJpaRepository.save(entity);

        return personMapper.personJpaEntityToPerson(savedEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Person> findAll() {
        return personJpaRepository.findAll()
                .stream()
                .map(personMapper::personJpaEntityToPerson)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Person> findById(PersonId personId) {
        Optional<PersonJpaEntity> existingPerson = personJpaRepository.findById(personId.getValue());

        return existingPerson.map(personMapper::personJpaEntityToPerson);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Person> findByEmail(Email email) {
        Optional<PersonJpaEntity> existingPerson = personJpaRepository.findByEmail(email.getValue());

        return existingPerson.map(personMapper::personJpaEntityToPerson);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Person> findByIdentificationNumber(IdentificationNumber identificationNumber) {
        Optional<PersonJpaEntity> existingPerson = personJpaRepository.findByIdentificationNumber(identificationNumber.getValue());

        return existingPerson.map(personMapper::personJpaEntityToPerson);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Person> findByPhoneNumber(PhoneNumber phoneNumber) {
        Optional<PersonJpaEntity> existingPerson = personJpaRepository.findByPhoneNumber(phoneNumber.getValue());

        return existingPerson.map(personMapper::personJpaEntityToPerson);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsById(PersonId personId) {
        return personJpaRepository.existsById(personId.getValue());
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsByEmail(Email email) {
        return personJpaRepository.existsByEmail(email.getValue());
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsByIdentificationNumber(IdentificationNumber identificationNumber) {
        return personJpaRepository.existsByIdentificationNumber(identificationNumber.getValue());
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsByPhoneNumber(PhoneNumber phoneNumber) {
        return personJpaRepository.existsByPhoneNumber(phoneNumber.getValue());
    }
}
