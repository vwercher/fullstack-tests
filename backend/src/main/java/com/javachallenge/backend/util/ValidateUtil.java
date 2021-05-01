package com.javachallenge.backend.util;

import com.javachallenge.backend.model.Person;
import org.springframework.stereotype.Component;

@Component
public class ValidateUtil {

    public void validateSavePerson(Person person) {
        if (person == null) {
            //TODO throw null
        } else {
            if (person.getName() == null || person.getName().isEmpty()) {
                //TODO throw null or empty
            }

            if (person.getBirthDate() == null) {
                //TODO throw null or empty
            } else {
                //TODO validate date
            }

            if (person.getCpf() == null || person.getCpf().isEmpty()) {
                //TODO throw null or empty
            } else {
                //TODO validate date
            }

            if (person.getEmail() != null && !person.getName().isEmpty()) {
                //TODO validate e-mail
            }
        }
    }
}
