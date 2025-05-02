package com.connectacomunidade.infrastructure.persistence.jpa.person;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "person", schema = "persons")
public class PersonJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "ref", unique = true, nullable = false)
    private UUID ref;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "email",unique = true, nullable = false)
    private String email;
    @Column(name = "identification_number",unique = true, nullable = false)
    private String identificationNumber;
    @Column(name = "birthdate", nullable = false)
    private LocalDate birthdate;
    @Column(name = "phone_number",unique = true, nullable = false)
    private String phoneNumber;

    public PersonJpaEntity(Integer id, UUID ref, String name, String email, String identificationNumber, LocalDate birthdate, String phoneNumber) {
        this.id = id;
        this.ref = ref;
        this.name = name;
        this.email = email;
        this.identificationNumber = identificationNumber;
        this.birthdate = birthdate;
        this.phoneNumber = phoneNumber;
    }

    public PersonJpaEntity(UUID ref, String name, String email, String identificationNumber, LocalDate birthdate, String phoneNumber) {
        this.ref = ref;
        this.name = name;
        this.email = email;
        this.identificationNumber = identificationNumber;
        this.birthdate = birthdate;
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {
        return id;
    }

    public UUID getRef() {
        return ref;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
