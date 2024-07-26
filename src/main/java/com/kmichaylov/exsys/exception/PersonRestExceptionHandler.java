package com.kmichaylov.exsys.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PersonRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<PersonErrorResponse> handleException(Exception ex) {
        PersonErrorResponse errorResponse = new PersonErrorResponse();
        errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<PersonErrorResponse> handleException(PersonNotFoundException ex) {
        PersonErrorResponse errorResponse = new PersonErrorResponse();
        errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setTimestamp(System.currentTimeMillis());


        return new ResponseEntity<PersonErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
