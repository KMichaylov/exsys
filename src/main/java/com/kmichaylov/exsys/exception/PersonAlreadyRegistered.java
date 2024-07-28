package com.kmichaylov.exsys.exception;

public class PersonAlreadyRegistered extends RuntimeException {
    public PersonAlreadyRegistered(String message) {
        super(message);
    }
}
