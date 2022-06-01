package com.webdev.productsystem.Users.Phone.Domain.ValueObjects;

import com.webdev.productsystem.Shared.Domain.Aggregate.CustomUUID;

public class PhoneId extends CustomUUID {
    private PhoneId() {}

    public PhoneId(String value) {
        super(value);

    }

}