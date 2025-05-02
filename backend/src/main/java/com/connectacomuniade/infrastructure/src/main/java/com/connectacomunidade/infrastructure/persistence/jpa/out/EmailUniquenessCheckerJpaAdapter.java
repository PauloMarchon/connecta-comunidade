package com.connectacomunidade.infrastructure.persistence.jpa.out;

import com.connectacomunidade.application.port.out.EmailUniquenessChecker;
import com.connectacomunidade.domain.valueobjects.Email;
import com.connectacomunidade.infrastructure.persistence.jpa.person.PersonJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class EmailUniquenessCheckerJpaAdapter implements EmailUniquenessChecker {
    private final PersonJpaRepository personJpaRepository;

    public EmailUniquenessCheckerJpaAdapter(PersonJpaRepository personJpaRepository) {
        this.personJpaRepository = personJpaRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isEmailAlreadyUsed(Email email) {
        return personJpaRepository.existsByEmail(email.getValue());
    }
}
