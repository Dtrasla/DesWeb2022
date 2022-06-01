package com.webdev.productsystem.Tours.Address.Domain.ValueObjects;

import com.webdev.productsystem.Shared.Domain.Aggregate.CustomUUID;

public class CityId extends CustomUUID {
    public CityId() {}

    public CityId(String value) {
        super(value);
    }
}
