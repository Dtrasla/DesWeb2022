package com.webdev.productsystem.Users.Phone.Domain.ValueObjects;

import com.webdev.productsystem.Shared.Domain.Aggregate.StringValueObject;
import com.webdev.productsystem.Users.Phone.Domain.Exceptions.InvalidString;
import com.webdev.productsystem.Users.Phone.Domain.Exceptions.LenghtInvalid;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneCountryCode extends StringValueObject {
    private PhoneCountryCode() {}

    public PhoneCountryCode(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        lengthValue(value);
        notAllowedCharacters(value);
    }

    private void lengthValue(String value) {
        if (value.length() < 2 || value.length() > 4) {
            throw new LenghtInvalid("Longitud Invalida");
        }
    }
    private void notAllowedCharacters(String value) {
        Pattern pat = Pattern.compile("[+][0-9]+");
        Matcher mat = pat.matcher(value);
        if (mat.matches()) {
        } else {
            throw new InvalidString("No válido");
        }}
}

