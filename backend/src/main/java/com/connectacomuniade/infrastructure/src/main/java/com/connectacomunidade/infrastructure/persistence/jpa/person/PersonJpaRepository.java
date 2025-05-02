package com.connectacomunidade.infrastructure.persistence.jpa.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface PersonJpaRepository extends JpaRepository<PersonJpaEntity, UUID> {
    @Query("SELECT person FROM PersonEntity person WHERE person.email =: email")
    Optional<PersonJpaEntity> findByEmail(String email);
    @Query("SELECT person FROM PersonEntity person WHERE person.identification_number =: identificationNumber")
    Optional<PersonJpaEntity> findByIdentificationNumber(String identificationNumber);
    @Query("SELECT person FROM PersonEntity person WHERE person.phone_number =: phoneNumber")
    Optional<PersonJpaEntity> findByPhoneNumber(String phoneNumber);

    boolean existsByEmail(String email);
    boolean existsByIdentificationNumber(String identificationNumber);
    boolean existsByPhoneNumber(String phoneNumber);
}
