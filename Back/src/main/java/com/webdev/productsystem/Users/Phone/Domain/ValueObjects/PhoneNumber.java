package com.webdev.productsystem.Users.Phone.Domain.ValueObjects;

import com.webdev.productsystem.Shared.Domain.Aggregate.StringValueObject;

import com.webdev.productsystem.Users.Phone.Domain.Exceptions.PhoneInvalidNumberString;
import com.webdev.productsystem.Users.Phone.Domain.Exceptions.PhoneInvalidNumberLength;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumber extends StringValueObject {
    private PhoneNumber() {
    }

    public PhoneNumber(String value) {
        validate(value);
        this.value = value;
    }


    private void validate(String value) {
        // lengthValue(value);
        // notAllowedCharacters(value);
    }

    private void lengthValue(String value) {
        if (value.length() < 7 || value.length() > 10) {
            throw new PhoneInvalidNumberLength("Number invalid length");
        }
    }

    private void notAllowedCharacters(String value) {
        Pattern pat = Pattern.compile("\\d+");
        Matcher mat = pat.matcher(value);
        if (mat.matches()) {
        } else {
            throw new PhoneInvalidNumberString("The number value is not valid");
        }
    }

}
