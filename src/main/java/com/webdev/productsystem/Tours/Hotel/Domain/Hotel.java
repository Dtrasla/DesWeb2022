package com.webdev.productsystem.Tours.Hotel.Domain;

import com.webdev.productsystem.Tours.Hotel.Domain.Entities.HotelAddress;
import com.webdev.productsystem.Tours.Hotel.Domain.ValueObjects.HotelId;
import com.webdev.productsystem.Tours.Hotel.Domain.ValueObjects.HotelName;

import java.util.HashMap;

public class Hotel {
    private HotelId id;
    private HotelName name;
    private HotelAddress address;

    public Hotel(HotelId id, HotelName name, HotelAddress address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public static Hotel create(HotelId id, HotelName name, HotelAddress address) {
        return new Hotel(id, name, address);
    }

    private HashMap<String, Object> createAddress() { return address.data(); }

    public HashMap<String, Object> data() {
        return new HashMap<>() {{
            put("id", id.value());
            put("name", name.value());
            put("address", id.value());
        }};
    }
}
