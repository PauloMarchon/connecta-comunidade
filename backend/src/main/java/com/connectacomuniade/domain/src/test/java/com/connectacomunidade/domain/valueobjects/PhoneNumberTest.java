package com.connectacomunidade.domain.valueobjects;

import com.connectacomunidade.domain.exception.InvalidValueException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PhoneNumberTest {

    @Test
    @DisplayName("Should create a valid phone number from the provided String")
    void shouldCreateValidPhoneNumberFromString() {
        String validPhoneNumber = "79996163432";
        PhoneNumber phoneNumber = PhoneNumber.of(validPhoneNumber);

        assertNotNull(phoneNumber);
        assertEquals(validPhoneNumber, phoneNumber.getValue());
    }

    //Redo when PhoneNumber isValid is implemented
    @Test
    @DisplayName("Should throw an exception when trying to create an invalid phone number")
    void shouldThrowExceptionForInvalidPhoneNumber() {
        String invalidPhone = "";

        Exception exception = assertThrows(InvalidValueException.class, () ->
                PhoneNumber.of(invalidPhone));

        assertEquals("Invalid phone number", exception.getMessage());
    }

    @Test
    @DisplayName("Phone numbers with the same value must be equals")
    void phoneNumberWithSameValueShouldBeEqual() {
        PhoneNumber phone1 = PhoneNumber.of("79996163432");
        PhoneNumber phone2 = PhoneNumber.of("79996163432");
        PhoneNumber phone3 = PhoneNumber.of("00000000");

        assertEquals(phone1, phone2);
        assertEquals(phone1.hashCode(), phone2.hashCode());
        assertNotEquals(phone1, phone3);
    }
}
