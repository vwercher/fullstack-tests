package com.javachallenge.backend.util;

import org.springframework.stereotype.Component;

@Component
public class NameUtil {

    public Boolean isValid(String name) {
        int minChar = 5;
        int letters = 0;
        int whiteSpaces = 0;
        for (int i=0; i<name.length(); i++) {
            if (Character.isLetter(name.charAt(i))) {
                letters++;
            } else if (Character.isWhitespace(name.charAt(i))) {
                whiteSpaces++;
            }
        }
        return whiteSpaces != 0 && minChar <= (whiteSpaces + letters);
    }
}
