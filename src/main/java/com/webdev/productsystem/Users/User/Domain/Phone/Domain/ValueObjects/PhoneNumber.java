package com.webdev.productsystem.Users.User.Domain.Phone.Domain.ValueObjects;

import com.webdev.productsystem.Shared.Domain.Aggregate.StringValueObject;

public class PhoneNumber extends StringValueObject {
    private PhoneNumber() {}

    public PhoneNumber(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {}
}
