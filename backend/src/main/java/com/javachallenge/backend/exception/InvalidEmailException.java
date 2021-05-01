package com.javachallenge.backend.exception;

import org.springframework.http.HttpStatus;

public class InvalidEmailException extends CommonException {

    public InvalidEmailException() {
        super("The e-mail informed is invalid.", HttpStatus.BAD_REQUEST);
    }
}
