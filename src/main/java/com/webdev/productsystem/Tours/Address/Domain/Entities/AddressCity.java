package com.webdev.productsystem.Tours.Address.Domain.Entities;

import java.util.HashMap;

public class AddressCity {
    private String id;
    private String name;
    private String country;

    public AddressCity(String id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public HashMap<String, Object> data() {
        return new HashMap<>() {{
            put("id", id);
            put("name", name);
            put("country", country);
        }};
    }
}
