package com.javachallenge.backend.util;

import com.javachallenge.backend.exception.*;
import com.javachallenge.backend.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidateUtil {

    @Autowired
    private NameUtil nameUtil;

    @Autowired
    private EmailUtil emailUtil;

    @Autowired
    private CPFUtil cpfUtil;

    public void validatePersonData(Person person) throws CommonException {

        if (person.getName() == null || person.getName().isEmpty()) {
            throw new MissingNameException();
        }

        if (!nameUtil.isValid(person.getName())) {
            throw new InvalidNameException();
        }

        if (person.getEmail() != null && person.getName().isEmpty() && !emailUtil.isValid(person.getEmail())) {
            throw new InvalidEmailException();
        }

        if (person.getBirthDate() == null) {
            throw new MissingDateException();
        }

        //TODO validar a data nascimento no front-end.

        if (person.getCpf() == null || person.getCpf().isEmpty()) {
            throw new MissingCpfException();
        }

        if (!cpfUtil.isValid(person.getCpf())) {
            throw new InvalidCpfException();
        }
    }
}
