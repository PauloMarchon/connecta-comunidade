package com.connectacomunidade.infrastructure.persistence.jpa.person;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PersonJpaRepository extends JpaRepository<PersonJpaEntity, Integer> {
    Optional<PersonJpaEntity> findByRef(UUID ref);
    Optional<PersonJpaEntity> findByEmail(String email);
    Optional<PersonJpaEntity> findByIdentificationNumber(String identificationNumber);
    Optional<PersonJpaEntity> findByPhoneNumber(String phoneNumber);

    boolean existsByRef (UUID ref);
    boolean existsByEmail(String email);
    boolean existsByIdentificationNumber(String identificationNumber);
    boolean existsByPhoneNumber(String phoneNumber);
}
