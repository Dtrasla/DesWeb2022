package com.webdev.productsystem.Tours.City.Domain.ValueObjects;

import com.webdev.productsystem.Shared.Domain.Aggregate.StringValueObject;

public class CityName extends StringValueObject {
    private CityName() {}

    public CityName(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {}

}
