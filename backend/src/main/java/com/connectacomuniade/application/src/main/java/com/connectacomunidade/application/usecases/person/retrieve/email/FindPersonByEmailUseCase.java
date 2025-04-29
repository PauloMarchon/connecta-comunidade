package com.connectacomunidade.application.usecases.person.retrieve.email;

import com.connectacomunidade.application.dto.ReadPerson;
import com.connectacomunidade.application.port.PersonRepository;
import com.connectacomunidade.application.usecases.UseCase;
import com.connectacomunidade.domain.person.Person;
import com.connectacomunidade.domain.valueobjects.Email;

public class FindPersonByEmailUseCase implements UseCase<FindPersonByEmailInput, FindPersonByEmailOutput> {
    private final PersonRepository personRepository;

    public FindPersonByEmailUseCase(PersonRepository personRepository) {
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

