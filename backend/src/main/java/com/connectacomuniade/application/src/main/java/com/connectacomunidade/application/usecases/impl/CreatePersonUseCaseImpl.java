package com.connectacomunidade.application.usecases.impl;

import com.connectacomunidade.application.exception.EmailAlreadyExistsException;
import com.connectacomunidade.application.exception.IdentificationNumberAlreadyExistsException;
import com.connectacomunidade.application.exception.PhoneNumberAlreadyExistsException;
import com.connectacomunidade.application.port.PersonRepository;
import com.connectacomunidade.application.port.out.EmailUniquenessChecker;
import com.connectacomunidade.application.port.out.IdentificationNumberUniquenessChecker;
import com.connectacomunidade.application.port.out.PhoneNumberUniquenessChecker;
import com.connectacomunidade.application.usecases.person.create.CreatePersonInput;
import com.connectacomunidade.application.usecases.person.create.CreatePersonOutput;
import com.connectacomunidade.application.usecases.person.create.CreatePersonUseCase;
import com.connectacomunidade.domain.person.Person;
import com.connectacomunidade.domain.valueobjects.Email;
import com.connectacomunidade.domain.valueobjects.IdentificationNumber;
import com.connectacomunidade.domain.valueobjects.PhoneNumber;

public class CreatePersonUseCaseImpl implements CreatePersonUseCase {
    private final PersonRepository personRepository;
    private final EmailUniquenessChecker emailUniquenessChecker;
    private final IdentificationNumberUniquenessChecker identificationNumberUniquenessChecker;
    private final PhoneNumberUniquenessChecker phoneNumberUniquenessChecker;

    public CreatePersonUseCaseImpl(PersonRepository personRepository, EmailUniquenessChecker emailUniquenessChecker, IdentificationNumberUniquenessChecker identificationNumberUniquenessChecker, PhoneNumberUniquenessChecker phoneNumberUniquenessChecker) {
        this.personRepository = personRepository;
        this.emailUniquenessChecker = emailUniquenessChecker;
        this.identificationNumberUniquenessChecker = identificationNumberUniquenessChecker;
        this.phoneNumberUniquenessChecker = phoneNumberUniquenessChecker;
    }

    @Override
    public CreatePersonOutput execute(CreatePersonInput createPersonInput) {
        Email email = Email.of(createPersonInput.email());
        if (emailUniquenessChecker.isEmailAlreadyUsed(email))
            throw new EmailAlreadyExistsException("Email already registered");

        IdentificationNumber identificationNumber = IdentificationNumber.create(createPersonInput.identificationNumber());
        if (identificationNumberUniquenessChecker.isIdentificationNumberAlreadyUsed(identificationNumber))
            throw new IdentificationNumberAlreadyExistsException("Identification number already registered");

        PhoneNumber phoneNumber = PhoneNumber.of(createPersonInput.phoneNumber());
        if (phoneNumberUniquenessChecker.isPhoneNumberAlreadyUsed(phoneNumber))
            throw new PhoneNumberAlreadyExistsException("Phone number already registered");

        return new CreatePersonOutput(
                personRepository.save(
                        Person.of(
                                createPersonInput.name(),
                                email,
                                identificationNumber,
                                createPersonInput.birthdate(),
                                phoneNumber
                        )
                )
        );
    }
}
