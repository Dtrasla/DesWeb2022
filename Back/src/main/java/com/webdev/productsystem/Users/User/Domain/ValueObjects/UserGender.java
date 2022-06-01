package com.webdev.productsystem.Users.User.Domain.ValueObjects;

import com.webdev.productsystem.Shared.Domain.Aggregate.StringValueObject;

public class UserGender extends StringValueObject {
    private UserGender() {}

    public UserGender(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {}
}
