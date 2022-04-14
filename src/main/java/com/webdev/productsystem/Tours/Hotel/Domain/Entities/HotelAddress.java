package com.webdev.productsystem.Tours.Hotel.Domain.Entities;

import java.util.HashMap;

public class HotelAddress {
    private String id;
    private String data;
    private String zipCode;
    private String city;

    public HotelAddress(String id, String data, String zipCode, String city) {
        this.id = id;
        this.data = data;
        this.zipCode = zipCode;
        this.city = city;
    }

    public HashMap<String, Object> data() {
        return new HashMap<>() {{
            put("id", id);
            put("data", data);
            put("zipCode", zipCode);
            put("city", city);
        }};
    }
}
