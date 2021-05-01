package com.javachallenge.backend.exception;

import org.springframework.http.HttpStatus;

public class MissingDateException extends CommonException {

    public MissingDateException() {
        super("The date attribute has no content.", HttpStatus.BAD_REQUEST);
    }
}
