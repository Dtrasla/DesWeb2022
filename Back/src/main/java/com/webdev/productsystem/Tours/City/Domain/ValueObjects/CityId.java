package com.webdev.productsystem.Tours.City.Domain.ValueObjects;

import com.webdev.productsystem.Shared.Domain.Aggregate.CustomUUID;
import com.webdev.productsystem.Shared.Domain.Aggregate.StringValueObject;

public class CityId extends CustomUUID {
    private CityId() {}

    public CityId(String value) {
        super(value);
    }
}
