package com.webdev.productsystem.Users.User.Domain.Entities;

import java.util.HashMap;

public class UserPhone {
    private String id;
    private String countryCode;
    private String number;

    public UserPhone(String id, String countryCode, String number) {
        this.id = id;
        this.countryCode = countryCode;
        this.number = number;
    }

    public HashMap<String, Object> data() {
        return new HashMap<>() {{
            put("id", id);
            put("countryCode", countryCode);
            put("number", number);
        }};
    }
}
