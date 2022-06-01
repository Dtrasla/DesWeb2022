package com.webdev.productsystem.Tours.City.Domain.ValueObjects;

import com.webdev.productsystem.Shared.Domain.Aggregate.CustomUUID;

public class TouristicLocationId extends CustomUUID {
    private TouristicLocationId() {}

    public TouristicLocationId(String value) {
        super(value);
    }
}
