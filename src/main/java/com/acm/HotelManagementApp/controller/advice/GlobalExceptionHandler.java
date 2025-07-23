package com.acm.HotelManagementApp.controller.advice;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleNoArgumentException(
            MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        Map<String, String> validationErrors = bindingResult.getFieldErrors()
                .stream()
                .collect(
                        Collectors.toMap(
                                FieldError::getField,
                                FieldError::getDefaultMessage,
                                (existing, replacement) -> existing + "; " + replacement // Chains multiple errors
                        )
                );
        return ResponseEntity.badRequest().body(validationErrors);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintsViolations(
            ConstraintViolationException ex) {
        BindingResult bindingResult = (BindingResult) ex.getConstraintViolations()
                .stream()
                .collect(
                        Collectors.toMap(
                                //ConstraintViolation::getPropertyPath,
                                violation -> violation.getPropertyPath().toString(), // Chains multiple errors
                                ConstraintViolation::getMessage,
                                (existing, replacement) -> existing + "; " + replacement // Chains multiple errors
                        )
                );
        return ResponseEntity.badRequest().body(bindingResult);
    }
}
