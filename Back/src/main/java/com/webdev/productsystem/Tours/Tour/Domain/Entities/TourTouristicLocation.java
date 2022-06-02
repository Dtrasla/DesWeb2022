package com.webdev.productsystem.Tours.Tour.Domain.Entities;

import java.util.HashMap;

public class TourTouristicLocation {
    private String id;
    private String name;
    private String tourId;

    public TourTouristicLocation(String id, String name, String tourId) {
        this.id = id;
        this.name = name;
        this.tourId = tourId;
    }

    public HashMap<String, Object> data() {
        return new HashMap<>() {{
           put("id", id);
           put("name", name);
        }};
    }
}
