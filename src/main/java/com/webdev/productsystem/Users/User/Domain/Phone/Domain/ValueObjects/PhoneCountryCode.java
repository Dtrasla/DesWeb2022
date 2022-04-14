package com.webdev.productsystem.Users.User.Domain.Phone.Domain.ValueObjects;

import com.webdev.productsystem.Shared.Domain.Aggregate.StringValueObject;

public class PhoneCountryCode extends StringValueObject {
    private PhoneCountryCode() {}

    public PhoneCountryCode(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {}
}
