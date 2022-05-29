package com.webdev.productsystem.Tours.Tour.Domain.Entities;

import java.util.HashMap;

public class TourTouristicLocation {
    private String id;
    private String name;

    public TourTouristicLocation(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public HashMap<String, Object> data() {
        return new HashMap<>() {{
           put("id", id);
           put("name", name);
        }};
    }
}
