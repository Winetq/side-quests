package com.epam.jap.validation;

import org.apache.commons.validator.EmailValidator;

public class Validator {
    public static boolean checkEmail(String email) {
        return EmailValidator.getInstance().isValid(email);
    }
}

