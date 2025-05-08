package com.connectacomunidade.application.usecases.impl;

import com.connectacomunidade.application.exception.PersonNotFoundException;
import com.connectacomunidade.application.port.PersonRepository;
import com.connectacomunidade.application.usecases.person.retrieve.identificationnumber.FindPersonByIdentificationNumberInput;
import com.connectacomunidade.application.usecases.person.retrieve.identificationnumber.FindPersonByIdentificationNumberOutput;
import com.connectacomunidade.application.usecases.person.retrieve.identificationnumber.FindPersonByIdentificationNumberUseCase;
import com.connectacomunidade.domain.person.Person;
import com.connectacomunidade.domain.valueobjects.IdentificationNumber;

public class FindPersonByIdentificationNumberUseCaseImpl implements FindPersonByIdentificationNumberUseCase {
    private final PersonRepository personRepository;

    public FindPersonByIdentificationNumberUseCaseImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public FindPersonByIdentificationNumberOutput execute(FindPersonByIdentificationNumberInput findPersonByIdentificationNumberInput) {
        IdentificationNumber identificationNumber = IdentificationNumber.create(findPersonByIdentificationNumberInput.identificationNumber());

        Person person = personRepository.findByIdentificationNumber(identificationNumber)
                .orElseThrow(() -> new PersonNotFoundException("Person not found"));

        return new FindPersonByIdentificationNumberOutput(person);
    }
}
