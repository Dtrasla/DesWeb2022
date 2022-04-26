package com.webdev.productsystem.Tours.Tour.Domain.ValueObjects;

import com.webdev.productsystem.Shared.Domain.Aggregate.StringValueObject;

public class TourName extends StringValueObject
 {
    private TourName(){}

    public TourName(String seat){
        validate(seat);
        this.value=seat;
    }

    public void validate(String seat){

        

    }
}
