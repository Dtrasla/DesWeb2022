package com.webdev.productsystem.Tours.Tour.Domain.ValueObjects;

import com.webdev.productsystem.Shared.Domain.Aggregate.CustomUUID;

public class TourId extends CustomUUID {
    private TourId(){}

    public TourId(String tourId) {
        super(tourId);
    }
}
