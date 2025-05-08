package com.connectacomunidade.infrastructure.web;

import com.connectacomunidade.application.exception.EmailAlreadyExistsException;
import com.connectacomunidade.application.exception.IdentificationNumberAlreadyExistsException;
import com.connectacomunidade.application.exception.PersonNotFoundException;
import com.connectacomunidade.application.exception.PhoneNumberAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleEmailAlreadyExistsException(EmailAlreadyExistsException ex) {
        HttpStatus status = HttpStatus.CONFLICT;

        ErrorResponse errorResponse = new ErrorResponse(
                status.value(),
                status.getReasonPhrase(),
                ex.getMessage()
        );

        return ResponseEntity.status(status).body(errorResponse);
    }

    @ExceptionHandler(IdentificationNumberAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleIdentificationNumberAlreadyExistsException(IdentificationNumberAlreadyExistsException ex) {
        HttpStatus status = HttpStatus.CONFLICT;

        ErrorResponse errorResponse = new ErrorResponse(
                status.value(),
                status.getReasonPhrase(),
                ex.getMessage()
        );

        return ResponseEntity.status(status).body(errorResponse);
    }

    @ExceptionHandler(PhoneNumberAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handlePhoneNumberAlreadyExistsException(PhoneNumberAlreadyExistsException ex) {
        HttpStatus status = HttpStatus.CONFLICT;

        ErrorResponse errorResponse = new ErrorResponse(
                status.value(),
                status.getReasonPhrase(),
                ex.getMessage()
        );

        return ResponseEntity.status(status).body(errorResponse);
    }

    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlePersonNotFoundException(PersonNotFoundException ex) {
        HttpStatus status = HttpStatus.NOT_FOUND;

        ErrorResponse errorResponse = new ErrorResponse(
                status.value(),
                status.getReasonPhrase(),
                ex.getMessage()
        );

        return ResponseEntity.status(status).body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR; // 500 Internal Server Error

        // Logar o erro aqui para debugging no servidor

        ErrorResponse errorResponse = new ErrorResponse(
                status.value(),
                status.getReasonPhrase(),
                "Ocorreu um erro inesperado. Tente novamente mais tarde."
        );

        return ResponseEntity.status(status).body(errorResponse);
    }
}
