package com.javachallenge.backend.exception;

import org.springframework.http.HttpStatus;

public class MissingNameException extends CommonException {

    public MissingNameException() {
        super("The name attribute has no content.", HttpStatus.BAD_REQUEST);
    }
}
