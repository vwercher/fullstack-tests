package com.javachallenge.backend.exception;

import org.springframework.http.HttpStatus;

public class MissingCpfException extends CommonException {

    public MissingCpfException() {
        super("The cpf attribute has no content.", HttpStatus.BAD_REQUEST);
    }
}
