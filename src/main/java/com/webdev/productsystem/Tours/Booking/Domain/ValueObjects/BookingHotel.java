package com.webdev.productsystem.Tours.Booking.Domain.ValueObjects;

import java.util.List;

import com.webdev.productsystem.Shared.Domain.Aggregate.ListValueObject;

public class BookingHotel extends ListValueObject{
    /*private String id;
    private String name;
    private String country;*/
    private BookingHotel(){}

    public BookingHotel(List<String> hotels){
        validate(hotels);
        this.value=hotels;
    }

    public void validate(List<String> hotels){

        

    }

    /*public HashMap<String, Object> data() {
        return new HashMap<>() {{
            put("id", id);
            put("zipCode", name);
            put("data", country);
        }};
    }*/
}
