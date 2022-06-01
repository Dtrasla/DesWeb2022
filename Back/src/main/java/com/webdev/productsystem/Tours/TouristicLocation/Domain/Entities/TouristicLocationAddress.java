package com.webdev.productsystem.Tours.TouristicLocation.Domain.Entities;

import java.util.HashMap;

public class TouristicLocationAddress {
    private String id;
    private String data;
    private String zipCode;
    private String cityId;

    public TouristicLocationAddress(String id, String data, String zipCode, String cityId) {
        this.id = id;
        this.data = data;
        this.zipCode = zipCode;
        this.cityId = cityId;
    }

    public HashMap<String, Object> data() {
        return new HashMap<>() {{
            put("id", id);
            put("data", data);
            put("zipCode", zipCode);
            put("city", cityId);
        }};
    }
}
