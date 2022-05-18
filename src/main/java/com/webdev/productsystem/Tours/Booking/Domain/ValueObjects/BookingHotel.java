package com.webdev.productsystem.Tours.Booking.Domain.ValueObjects;

import java.util.List;

import com.webdev.productsystem.Shared.Domain.Aggregate.CustomUUID;
import com.webdev.productsystem.Shared.Domain.Aggregate.ListValueObject;

public class BookingHotel extends CustomUUID {
    /*private String id;
    private String name;
    private String country;*/
    private BookingHotel(){}

      public BookingHotel(String value)
        {
            super(value);
        }



    /*public HashMap<String, Object> data() {
        return new HashMap<>() {{
            put("id", id);
            put("zipCode", name);
            put("data", country);
        }};
    }*/
}
