package com.javachallenge.backend.util;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {

    public boolean isValid(String email) {
        return EmailValidator.getInstance().isValid(email);
    }
}
