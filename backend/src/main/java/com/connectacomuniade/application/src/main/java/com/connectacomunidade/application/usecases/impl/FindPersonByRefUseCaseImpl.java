package com.connectacomunidade.application.usecases.impl;

import com.connectacomunidade.application.port.PersonRepository;
import com.connectacomunidade.application.usecases.person.retrieve.ref.FindPersonByRefInput;
import com.connectacomunidade.application.usecases.person.retrieve.ref.FindPersonByRefOutput;
import com.connectacomunidade.application.usecases.person.retrieve.ref.FindPersonByRefUseCase;
import com.connectacomunidade.domain.person.Person;

public class FindPersonByRefUseCaseImpl implements FindPersonByRefUseCase {
    private final PersonRepository personRepository;

    public FindPersonByRefUseCaseImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public FindPersonByRefOutput execute(FindPersonByRefInput findPersonByRefInput) {
        Person person = personRepository.findByRef(findPersonByRefInput.ref())
                .orElseThrow(() -> new IllegalArgumentException(""));

        return new FindPersonByRefOutput(person);
    }
}
