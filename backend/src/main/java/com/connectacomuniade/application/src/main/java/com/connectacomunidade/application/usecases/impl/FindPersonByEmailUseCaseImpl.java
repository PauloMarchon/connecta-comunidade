package com.connectacomunidade.application.usecases.impl;

import com.connectacomunidade.application.dto.ReadPerson;
import com.connectacomunidade.application.port.PersonRepository;
import com.connectacomunidade.application.usecases.person.retrieve.email.FindPersonByEmailInput;
import com.connectacomunidade.application.usecases.person.retrieve.email.FindPersonByEmailOutput;
import com.connectacomunidade.application.usecases.person.retrieve.email.FindPersonByEmailUseCase;
import com.connectacomunidade.domain.person.Person;
import com.connectacomunidade.domain.valueobjects.Email;

public class FindPersonByEmailUseCaseImpl implements FindPersonByEmailUseCase {
    private final PersonRepository personRepository;

    public FindPersonByEmailUseCaseImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public FindPersonByEmailOutput execute(FindPersonByEmailInput findPersonByEmailInput) {
        Email email = Email.of(findPersonByEmailInput.email());

        Person person = personRepository.findByEmail(email).orElseThrow(
                () -> new IllegalArgumentException(""));

        return new FindPersonByEmailOutput(
                ReadPerson.fromPerson(person)
        );
    }
}
