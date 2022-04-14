package com.webdev.productsystem.Tours.Hotel.Domain.ValueObjects;

import com.webdev.productsystem.Shared.Domain.Aggregate.StringValueObject;

public class HotelName extends StringValueObject {
    private HotelName() {}

    public HotelName(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {}
}
