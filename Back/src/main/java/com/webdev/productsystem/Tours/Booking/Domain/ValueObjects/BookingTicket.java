package com.webdev.productsystem.Tours.Booking.Domain.ValueObjects;

import java.util.List;

import com.webdev.productsystem.Shared.Domain.Aggregate.ListValueObject;
import com.webdev.productsystem.Shared.Domain.Aggregate.StringValueObject;

public class BookingTicket extends StringValueObject{
    /*private String id;
    private String name;
    private String country;*/
    private BookingTicket(){}

    public BookingTicket(String ticket){
        validate(ticket);
        this.value=ticket;
    }

    public void validate(String ticket){

        

    }

    /*public HashMap<String, Object> data() {
        return new HashMap<>() {{
            put("id", id);
            put("zipCode", name);
            put("data", country);
        }};
    }*/
}
