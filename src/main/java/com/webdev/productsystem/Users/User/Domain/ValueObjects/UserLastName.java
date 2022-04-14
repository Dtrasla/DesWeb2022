package com.webdev.productsystem.Users.User.Domain.ValueObjects;

import com.webdev.productsystem.Shared.Domain.Aggregate.StringValueObject;

public class UserLastName extends StringValueObject {
    private UserLastName() {}

    public UserLastName(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {}

}
