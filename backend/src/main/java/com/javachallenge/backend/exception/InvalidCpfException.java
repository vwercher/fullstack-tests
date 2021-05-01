package com.javachallenge.backend.exception;

import org.springframework.http.HttpStatus;

public class InvalidCpfException extends CommonException {

    public InvalidCpfException() {
        super("The CPF informed is invalid.", HttpStatus.BAD_REQUEST);
    }
}
