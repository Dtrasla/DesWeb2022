package com.webdev.productsystem.Tours.Address.Domain.ValueObjects;

import com.webdev.productsystem.Shared.Domain.Aggregate.StringValueObject;

public class AddressId extends StringValueObject {
    private AddressId() {}

    public AddressId(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {}
}
