package com.domain.project.core.exception;

import com.domain.project.common.utils.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ExceptionDetails> handleNotFoundExceptions(EntityNotFoundException ex) {
        return new ResponseEntity<>(getExceptionDetailsObject(ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UniqueConstraintViolationException.class)
    public ResponseEntity<ExceptionDetails> handleUniqueValidationException(UniqueConstraintViolationException ex) {
        return createValidationExceptionsResponse(List.of(
                FieldErrorDetails.builder()
                        .fieldName(ex.getFieldName())
                        .errorMessage(ex.getMessage())
                        .build())
        );
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ExceptionDetails> handleIllegalArgumentException(IllegalArgumentException ex) {
        return new ResponseEntity<>(getExceptionDetailsObject(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ExceptionDetails> handleAccessDeniedException(AccessDeniedException ex) {
        return new ResponseEntity<>(getExceptionDetailsObject(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<ExceptionDetails> createValidationExceptionsResponse(List<FieldErrorDetails> fieldErrors) {
        return new ResponseEntity<>(getExceptionDetailsObject(fieldErrors
        ), HttpStatus.BAD_REQUEST);
    }

    private ExceptionDetails getExceptionDetailsObject(List<FieldErrorDetails> fieldErrors) {
        return ExceptionDetails.builder()
                .fieldErrorDetails(fieldErrors)
                .message("Validation violation")
                .build();
    }

    private ExceptionDetails getExceptionDetailsObject(String message) {
        return ExceptionDetails.builder()
                .message(message)
                .build();
    }
}