package com.connectacomunidade.infrastructure.persistence.jpa.out;

import com.connectacomunidade.application.port.out.PhoneNumberUniquenessChecker;
import com.connectacomunidade.domain.valueobjects.PhoneNumber;
import com.connectacomunidade.infrastructure.persistence.jpa.person.PersonJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class PhoneNumberUniquenessCheckerJpaAdapter implements PhoneNumberUniquenessChecker {
    private final PersonJpaRepository personJpaRepository;

    public PhoneNumberUniquenessCheckerJpaAdapter(PersonJpaRepository personJpaRepository) {
        this.personJpaRepository = personJpaRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isPhoneNumberAlreadyUsed(PhoneNumber phoneNumber) {
        return personJpaRepository.existsByPhoneNumber(phoneNumber.getValue());
    }
}
