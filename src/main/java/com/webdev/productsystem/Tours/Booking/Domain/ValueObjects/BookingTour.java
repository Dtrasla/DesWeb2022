package com.webdev.productsystem.Tours.Booking.Domain.ValueObjects;

import java.util.List;

import com.webdev.productsystem.Shared.Domain.Aggregate.ListValueObject;
import com.webdev.productsystem.Shared.Domain.Aggregate.StringValueObject;

public class BookingTour extends StringValueObject{
    /*private String id;
    private String name;
    private String country;*/
    private BookingTour(){}

    public BookingTour(String tour){
        validate(tour);
        this.value=tour;
    }

    public void validate(String tour){

        

    }

    /*public HashMap<String, Object> data() {
        return new HashMap<>() {{
            put("id", id);
            put("zipCode", name);
            put("data", country);
        }};
    }*/
}
