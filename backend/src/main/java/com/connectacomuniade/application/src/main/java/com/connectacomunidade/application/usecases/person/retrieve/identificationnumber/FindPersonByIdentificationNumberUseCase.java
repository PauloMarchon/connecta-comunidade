package com.connectacomunidade.application.usecases.person.retrieve.identificationnumber;

import com.connectacomunidade.application.dto.ReadPerson;
import com.connectacomunidade.application.port.PersonRepository;
import com.connectacomunidade.application.usecases.UseCase;
import com.connectacomunidade.domain.person.Person;
import com.connectacomunidade.domain.valueobjects.IdentificationNumber;

public class FindPersonByIdentificationNumberUseCase implements UseCase<FindPersonByIdentificationNumberInput, FindPersonByIdentificationNumberOutput> {
    private final PersonRepository personRepository;

    public FindPersonByIdentificationNumberUseCase(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public FindPersonByIdentificationNumberOutput execute(FindPersonByIdentificationNumberInput findPersonByIdentificationNumberInput) {
        IdentificationNumber identificationNumber = IdentificationNumber.create(findPersonByIdentificationNumberInput.identificationNumber());

        Person person = personRepository.findByIdentificationNumber(identificationNumber)
                .orElseThrow(() -> new IllegalArgumentException(""));

        return new FindPersonByIdentificationNumberOutput(
                ReadPerson.fromPerson(person)
        );
    }
}
