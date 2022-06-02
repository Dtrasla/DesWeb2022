package com.webdev.productsystem.Users.User.Domain.Entities;

import java.util.HashMap;

public class UserPhone {
    private String id;
    private String countryCode;
    private String number;
    private String userId;

    public UserPhone(String id, String countryCode, String number, String userId) {
        this.id = id;
        this.countryCode = countryCode;
        this.number = number;
        this.userId = userId;
    }

    public HashMap<String, Object> data() {
        return new HashMap<>() {{
            put("id", id);
            put("countryCode", countryCode);
            put("number", number);
        }};
    }
}
