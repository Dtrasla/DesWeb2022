package com.webdev.productsystem.Tours.Hotel.Domain.ValueObjects;

import com.webdev.productsystem.Shared.Domain.Aggregate.StringValueObject;

public class HotelId extends StringValueObject {
    private HotelId() {}

    public HotelId(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {}
}
