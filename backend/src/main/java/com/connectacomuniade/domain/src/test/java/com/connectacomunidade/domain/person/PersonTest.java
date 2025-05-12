package com.connectacomunidade.domain.person;

import com.connectacomunidade.domain.exception.NotificationException;
import com.connectacomunidade.domain.valueobjects.Email;
import com.connectacomunidade.domain.valueobjects.IdentificationNumber;
import com.connectacomunidade.domain.valueobjects.PhoneNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @Test
    @DisplayName("")
    void shouldCreateValidPerson() {
        Person person = Person.of(
                "Raimundo Marcos Antonio Fernandes",
                Email.of("raimundomarcos@email.com"),
                IdentificationNumber.create("47481929092"),
                LocalDate.of(1989,6,2),
                PhoneNumber.of("66989612707")
        );

        assertNotNull(person);
        assertNotNull(person.getRef());
        assertEquals("Raimundo Marcos Antonio Fernandes", person.getName());
        assertEquals("raimundomarcos@email.com", person.getEmail().getValue());
        assertEquals("47481929092", person.getIdentificationNumber().getValue());
        assertEquals(LocalDate.of(1989,6,2), person.getBirthdate());
        assertEquals("66989612707", person.getPhoneNumber().getValue());
    }

    @Test
    @DisplayName("Should throw exception for invalid Person name")
    void shouldThrowExceptionForInvalidPersonName() {
        String invalidName = " ";

        Exception exception = assertThrows(NotificationException.class, () ->
                Person.of(
                invalidName,
                Email.of("raimundomarcos@email.com"),
                IdentificationNumber.create("47481929092"),
                LocalDate.of(1989,6,2),
                PhoneNumber.of("66989612707")
                )
        );
    }
}
