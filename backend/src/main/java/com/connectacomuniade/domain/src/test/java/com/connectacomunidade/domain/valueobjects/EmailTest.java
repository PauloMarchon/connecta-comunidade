package com.connectacomunidade.domain.valueobjects;

import com.connectacomunidade.domain.exception.InvalidValueException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmailTest {

    @Test
    @DisplayName("Should create a valid email from the provided String")
    void shouldCreateValidEmailFromString(){
        String validEmail = "email@email.com";
        Email email = Email.of(validEmail);

        assertNotNull(email);
        assertEquals(validEmail, email.getValue());
    }

    //Redo when Email isValid is implemented
    @Test
    @DisplayName("Should throw an exception when trying to create an invalid email")
    void shouldThrowExceptionForInvalidEmail() {
        String invalidEmail = "";

        Exception exception = assertThrows(InvalidValueException.class,
                () -> Email.of(invalidEmail));

        assertEquals("The email provided is invalid", exception.getMessage());
    }

    @Test
    @DisplayName("Email with the same value must be equals")
    void emailsWithSameValueShouldBeEqual() {
        Email email1 = Email.of("test@email.com");
        Email email2 = Email.of("test@email.com");
        Email email3 = Email.of("another@email.com");

        assertEquals(email1, email2);
        assertEquals(email1.hashCode(), email2.hashCode());
        assertNotEquals(email1, email3);
    }
}
