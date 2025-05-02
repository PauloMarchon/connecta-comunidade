package com.connectacomunidade.infrastructure.persistence.jpa.out;

import com.connectacomunidade.application.port.out.IdentificationNumberUniquenessChecker;
import com.connectacomunidade.domain.valueobjects.IdentificationNumber;
import com.connectacomunidade.infrastructure.persistence.jpa.person.PersonJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class IdentificationNumberUniquenessCheckerJpaAdapter implements IdentificationNumberUniquenessChecker {
    private final PersonJpaRepository personJpaRepository;

    public IdentificationNumberUniquenessCheckerJpaAdapter(PersonJpaRepository personJpaRepository) {
        this.personJpaRepository = personJpaRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isIdentificationNumberAlreadyUsed(IdentificationNumber identificationNumber) {
        return personJpaRepository.existsByIdentificationNumber(identificationNumber.getValue());
    }
}
