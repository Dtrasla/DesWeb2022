package com.webdev.productsystem.Tours.Tour.Domain.Entities;

import java.util.HashMap;

public class TourCity {
    private String id;
    private String name;
    private String country;

    public TourCity(String id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public HashMap<String, Object> data() {
        return new HashMap<>() {{
            put("id", id);
            put("zipCode", name);
            put("data", country);
        }};
    }
}
