package com.webdev.productsystem.Tours.City.Domain.ValueObjects;

import com.webdev.productsystem.Shared.Domain.Aggregate.StringValueObject;

public class CityCountry extends StringValueObject
 {
    private CityCountry() {}

    public CityCountry(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {}
}
