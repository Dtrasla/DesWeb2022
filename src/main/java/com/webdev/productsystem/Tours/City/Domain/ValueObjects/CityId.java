package com.webdev.productsystem.Tours.City.Domain.ValueObjects;

import com.webdev.productsystem.Shared.Domain.Aggregate.StringValueObject;

public class CityId extends StringValueObject {
    private CityId() {}

    public CityId(String value){
        validate(value);
        this.value = value;
    }

    private void validate(String value) {}

}
