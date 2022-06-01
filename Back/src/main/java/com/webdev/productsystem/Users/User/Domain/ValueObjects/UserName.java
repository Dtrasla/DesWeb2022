package com.webdev.productsystem.Users.User.Domain.ValueObjects;

import com.webdev.productsystem.Shared.Domain.Aggregate.StringValueObject;
import com.webdev.productsystem.Users.User.Domain.Exceptions.InvalidUserEmail;
import com.webdev.productsystem.Users.User.Domain.Exceptions.InvalidUserName;

public class UserName extends StringValueObject {
    private UserName() {}

    public UserName(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        nameLength(value);
    }

    private void nameLength(String value) {
        if (value.length() < 5 || value.length() > 30) {
            throw new InvalidUserName("Longitud Invalida");
        }
    }

}
