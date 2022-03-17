package com.webdev.productsystem.Tours.Address.Domain.ValueObjects;

import com.webdev.productsystem.Shared.Domain.Aggregate.StringValueObject;
import com.webdev.productsystem.Tours.Address.Domain.Address;

public class AddressData extends StringValueObject {
    public AddressData(String value) {
        validate(value);
    }

    private void validate(String value) {

    }

    private void formatAddress(String value) {
        value.matches("");
    }
}
