package com.connectacomunidade.domain.valueobjects;

import com.connectacomunidade.domain.exception.InvalidValueException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IdentificationNumberTest {

    @Test
    @DisplayName("Should create a valid CPF from the provided String")
    void shouldCreateValidCPFNumberFromString() {
        String cpf = "49974952042";
        IdentificationNumber identificationNumber = IdentificationNumber.create(cpf);

        assertNotNull(identificationNumber);
        assertEquals(cpf, identificationNumber.getValue());
        assertInstanceOf(CPF.class, identificationNumber);
    }

    @Test
    @DisplayName("Should create a valid CNPJ from the provided String")
    void shouldCreateValidCNPJNumberFromString() {
        String cnpj = "68660435000104";
        IdentificationNumber identificationNumber = IdentificationNumber.create(cnpj);

        assertNotNull(identificationNumber);
        assertEquals(cnpj, identificationNumber.getValue());
        assertInstanceOf(CNPJ.class, identificationNumber);
    }

    @Test
    @DisplayName("Should throw an exception when trying to create an invalid identification number")
    void shouldThrowExceptionForInvalidIdentificationNumber() {
        String invalidNumber = "135454";

        Exception exception = assertThrows(InvalidValueException.class, () ->
                IdentificationNumber.create(invalidNumber));

        assertEquals("Invalid identification number", exception.getMessage());
    }

    //Redo when IdentificationNumber isValid is implemented
    @Test
    @DisplayName("Should throw an exception when trying to create an invalid CPF")
    void shouldThrowExceptionForInvalidCPFNumber() {
        String invalidCPF = "";

        Exception exception = assertThrows(InvalidValueException.class, () ->
                IdentificationNumber.create(invalidCPF));

        assertEquals("Invalid identification number", exception.getMessage());
    }

    //Redo when IdentificationNumber isValid is implemented
    @Test
    @DisplayName("Should throw an exception when trying to create an invalid CNPJ")
    void shouldThrowExceptionForInvalidCNPJNumber() {
        String invalidCNPJ = "";

        Exception exception = assertThrows(InvalidValueException.class, () ->
                IdentificationNumber.create(invalidCNPJ));

        assertEquals("Invalid identification number", exception.getMessage());
    }

    @Test
    @DisplayName("CPF with the same value must be equals")
    void CpfWithSameValueShouldBeEqual() {
        IdentificationNumber cpf1 = IdentificationNumber.create("49974952042");
        IdentificationNumber cpf2 = IdentificationNumber.create("49974952042");
        IdentificationNumber cpf3 = IdentificationNumber.create("63614898091");

        assertEquals(cpf1, cpf2);
        assertEquals(cpf1.hashCode(), cpf2.hashCode());
        assertNotEquals(cpf1, cpf3);
    }

    @Test
    @DisplayName("CNPJ with the same value must be equals")
    void CnpjWithSameValueShouldBeEqual() {
        IdentificationNumber cnpj1 = IdentificationNumber.create("74315887000143");
        IdentificationNumber cnpj2 = IdentificationNumber.create("74315887000143");
        IdentificationNumber cnpj3 = IdentificationNumber.create("28431179000150");

        assertEquals(cnpj1, cnpj2);
        assertEquals(cnpj1.hashCode(), cnpj2.hashCode());
        assertNotEquals(cnpj1, cnpj3);
    }
}
