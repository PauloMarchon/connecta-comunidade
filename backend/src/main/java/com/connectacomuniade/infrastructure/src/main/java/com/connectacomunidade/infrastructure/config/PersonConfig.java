package com.connectacomunidade.infrastructure.config;

import com.connectacomunidade.application.port.PersonRepository;
import com.connectacomunidade.application.port.out.EmailUniquenessChecker;
import com.connectacomunidade.application.port.out.IdentificationNumberUniquenessChecker;
import com.connectacomunidade.application.port.out.PhoneNumberUniquenessChecker;
import com.connectacomunidade.application.usecases.impl.CreatePersonUseCaseImpl;
import com.connectacomunidade.application.usecases.impl.FindPersonByRefUseCaseImpl;
import com.connectacomunidade.application.usecases.person.create.CreatePersonUseCase;
import com.connectacomunidade.application.usecases.person.retrieve.ref.FindPersonByRefUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonConfig {

    @Bean
    public CreatePersonUseCase createPersonUseCase(
            PersonRepository personRepository,
            EmailUniquenessChecker emailUniquenessChecker,
            IdentificationNumberUniquenessChecker identificationNumberUniquenessChecker,
            PhoneNumberUniquenessChecker phoneNumberUniquenessChecker) {
        return new CreatePersonUseCaseImpl(personRepository, emailUniquenessChecker, identificationNumberUniquenessChecker, phoneNumberUniquenessChecker);
    }

    @Bean
    public FindPersonByRefUseCase findPersonByRefUseCase(PersonRepository personRepository) {
        return new FindPersonByRefUseCaseImpl(personRepository);
    }
}
