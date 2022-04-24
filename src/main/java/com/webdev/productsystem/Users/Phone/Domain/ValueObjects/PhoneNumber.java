package com.webdev.productsystem.Users.Phone.Domain.ValueObjects;

import com.webdev.productsystem.Shared.Domain.Aggregate.StringValueObject;

import com.webdev.productsystem.Users.Phone.Domain.Exceptions.InvalidNumberString;
import com.webdev.productsystem.Users.Phone.Domain.Exceptions.InvalidNumberLenght;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumber extends StringValueObject {
    private PhoneNumber() {}

    public PhoneNumber(String value) {
        validate(value);
        this.value = value;
    }
    private void lengthValue(String value) {
        if (value.length() < 7 || value.length() > 10) {
            throw new InvalidNumberLenght("Number invalid lenght");
        }
    }
    private void validate(String value) {
        lengthValue(value);
        notAllowedCharacters(value);
    }
    private void notAllowedCharacters(String value) {
        Pattern pat = Pattern.compile("[0-9]+");
        Matcher mat = pat.matcher(value);
        if (mat.matches()) {
        } else {
            throw new InvalidNumberString("The number value is not valid");
        }
    }

}
