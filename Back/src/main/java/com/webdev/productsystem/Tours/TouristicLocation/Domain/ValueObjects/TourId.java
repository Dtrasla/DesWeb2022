package com.webdev.productsystem.Tours.TouristicLocation.Domain.ValueObjects;

import com.webdev.productsystem.Shared.Domain.Aggregate.CustomUUID;

public class TourId extends CustomUUID {
    private TourId(){}

    public TourId(String value) {
        super(value);
    }
}
