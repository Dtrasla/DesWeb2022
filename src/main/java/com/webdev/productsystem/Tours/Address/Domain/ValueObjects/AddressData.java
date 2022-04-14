package com.webdev.productsystem.Tours.Address.Domain.ValueObjects;

import com.webdev.productsystem.Shared.Domain.Aggregate.StringValueObject;

public class AddressData extends StringValueObject {
    private AddressData() {}

    public AddressData(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {}
}
