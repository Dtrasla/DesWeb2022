package com.webdev.productsystem.Tours.Tour.Domain.ValueObjects;

import com.webdev.productsystem.Shared.Domain.Aggregate.CustomUUID;
import com.webdev.productsystem.Shared.Domain.Aggregate.StringValueObject;

public class TouristicLocationId extends CustomUUID {
    private TouristicLocationId() {}

    public TouristicLocationId(String value) {
        super(value);
    }
}
