package com.webdev.productsystem.Tours.Hotel.Domain.ValueObjects;

import com.webdev.productsystem.Shared.Domain.Aggregate.CustomUUID;
import com.webdev.productsystem.Shared.Domain.Aggregate.StringValueObject;

public class HotelId extends CustomUUID {
    private HotelId() {}

    public HotelId(String value) {
        super(value);
    }
}
