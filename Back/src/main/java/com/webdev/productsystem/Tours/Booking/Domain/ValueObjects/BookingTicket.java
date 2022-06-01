package com.webdev.productsystem.Tours.Booking.Domain.ValueObjects;

import java.util.List;

import com.webdev.productsystem.Shared.Domain.Aggregate.CustomUUID;
import com.webdev.productsystem.Shared.Domain.Aggregate.ListValueObject;
import com.webdev.productsystem.Shared.Domain.Aggregate.StringValueObject;

public class BookingTicket extends CustomUUID{
    /*private String id;
    private String name;
    private String country;*/
    private BookingTicket(){}

    public BookingTicket(String value)
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
