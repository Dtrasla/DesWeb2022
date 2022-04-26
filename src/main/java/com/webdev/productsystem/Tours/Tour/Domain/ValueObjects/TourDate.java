package com.webdev.productsystem.Tours.Tour.Domain.ValueObjects;

import com.webdev.productsystem.Shared.Domain.Aggregate.StringValueObject;

public class TourDate extends StringValueObject{
    private TourDate(){}

    public TourDate(String booking){
        validate(booking);
        this.value=booking;
    }

    public void validate(String booking){

        

    }
}
