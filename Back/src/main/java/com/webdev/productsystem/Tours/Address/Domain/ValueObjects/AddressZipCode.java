package com.webdev.productsystem.Tours.Address.Domain.ValueObjects;

import com.webdev.productsystem.Shared.Domain.Aggregate.StringValueObject;

public class AddressZipCode extends StringValueObject {
    private AddressZipCode() {}

    public AddressZipCode(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {}
}
