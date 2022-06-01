package com.webdev.productsystem.Tours.Address.Domain.ValueObjects;

import com.webdev.productsystem.Shared.Domain.Aggregate.CustomUUID;
import com.webdev.productsystem.Shared.Domain.Aggregate.StringValueObject;

public class AddressId extends CustomUUID {
    private AddressId() {}

    public AddressId(String value) {
        super(value);
    }

}
