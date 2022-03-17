package com.webdev.productsystem.Tours.Hotel.Domain.ValueObjects;

import com.webdev.productsystem.Shared.Domain.Aggregate.StringValueObject;

public class HotelName extends StringValueObject {

    public HotelName(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) { notAllowedCharacters(value); }

    private void notAllowedCharacters(String value) {
        if(value.matches(".*\\d.*"))
            throw new RuntimeException("Invalid hotel name");
    }
}
