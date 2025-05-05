package com.connectacomunidade.infrastructure.config;

import com.connectacomunidade.application.port.PersonRepository;
import com.connectacomunidade.application.port.out.EmailUniquenessChecker;
import com.connectacomunidade.application.port.out.IdentificationNumberUniquenessChecker;
import com.connectacomunidade.application.port.out.PhoneNumberUniquenessChecker;
import com.connectacomunidade.application.usecases.impl.CreatePersonUseCaseImpl;
import com.connectacomunidade.application.usecases.person.create.CreatePersonUseCase;
import com.connectacomunidade.infrastructure.mapper.PersonMapper;
import com.connectacomunidade.infrastructure.persistence.jpa.out.EmailUniquenessCheckerJpaAdapter;
import com.connectacomunidade.infrastructure.persistence.jpa.out.IdentificationNumberUniquenessCheckerJpaAdapter;
import com.connectacomunidade.infrastructure.persistence.jpa.out.PhoneNumberUniquenessCheckerJpaAdapter;
import com.connectacomunidade.infrastructure.persistence.jpa.person.PersonJpaAdapter;
import com.connectacomunidade.infrastructure.persistence.jpa.person.PersonJpaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonConfig {

    @Bean
    public PersonRepository personRepository(PersonJpaRepository personJpaRepository, PersonMapper personMapper) {
        return new PersonJpaAdapter(personJpaRepository, personMapper);
    }

    @Bean
    public EmailUniquenessChecker emailUniquenessChecker(PersonJpaRepository personJpaRepository) {
        return new EmailUniquenessCheckerJpaAdapter(personJpaRepository);
    }

    @Bean
    public IdentificationNumberUniquenessChecker identificationNumberUniquenessChecker(PersonJpaRepository personJpaRepository) {
        return new IdentificationNumberUniquenessCheckerJpaAdapter(personJpaRepository);
    }

    @Bean
    public PhoneNumberUniquenessChecker phoneNumberUniquenessChecker(PersonJpaRepository personJpaRepository) {
        return new PhoneNumberUniquenessCheckerJpaAdapter(personJpaRepository);
    }

    @Bean
    public CreatePersonUseCase createPersonUseCase(
            PersonRepository personRepository,
            EmailUniquenessChecker emailUniquenessChecker,
            IdentificationNumberUniquenessChecker identificationNumberUniquenessChecker,
            PhoneNumberUniquenessChecker phoneNumberUniquenessChecker) {
        return new CreatePersonUseCaseImpl(personRepository, emailUniquenessChecker, identificationNumberUniquenessChecker, phoneNumberUniquenessChecker);
    }
}
