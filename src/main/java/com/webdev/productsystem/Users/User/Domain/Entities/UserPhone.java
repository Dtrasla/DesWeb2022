package com.webdev.productsystem.Users.User.Domain.Entities;

import java.util.HashMap;

public class UserPhone {
    private Integer id;
    private Integer countryCode;
    private Integer number;

    public UserPhone(Integer id, Integer countryCode, Integer number) {
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
