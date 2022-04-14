package com.webdev.productsystem.Users.User.Domain.ValueObjects;

import com.webdev.productsystem.Shared.Domain.Aggregate.StringValueObject;

public class UserBirthday extends StringValueObject {
    private UserBirthday() {}

    public UserBirthday(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {}

}
