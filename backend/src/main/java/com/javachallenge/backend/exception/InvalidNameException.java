package com.javachallenge.backend.exception;

import org.springframework.http.HttpStatus;

public class InvalidNameException extends CommonException {

    public InvalidNameException() {
        super("The name informed is invalid.", HttpStatus.BAD_REQUEST);
    }
}
