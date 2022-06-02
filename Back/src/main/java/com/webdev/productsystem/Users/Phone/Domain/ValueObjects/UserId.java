package com.webdev.productsystem.Users.Phone.Domain.ValueObjects;

import com.webdev.productsystem.Shared.Domain.Aggregate.CustomUUID;

public class UserId extends CustomUUID {
    private UserId() {}

    public UserId(String value) {
        super(value);
    }

}