package com.webdev.productsystem.Tours.Hotel.Domain.ValueObjects;

import com.webdev.productsystem.Shared.Domain.Aggregate.StringValueObject;
import com.webdev.productsystem.Tours.Hotel.Domain.Exceptions.HotelNameInvalidLength;

public class HotelName extends StringValueObject {
    private HotelName() {}

    public HotelName(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        validateLength(value);
    }

    private void validateLength(String value) {
        if(value.length() < 5 || value.length() > 25)
            throw new HotelNameInvalidLength("Hotel name must be between 5 and 25 characters");
    }
}
