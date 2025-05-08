package com.connectacomunidade.infrastructure.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public record CreatePersonRequest(
        @NotBlank @Size(min = 4) String name,
        @NotBlank @Email String email,
        @NotBlank String identificationNumber,
        @NotNull @Past LocalDate birthdate,
        @NotBlank String phoneNumber
) {
}
