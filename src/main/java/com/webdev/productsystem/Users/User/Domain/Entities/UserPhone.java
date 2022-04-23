package com.webdev.productsystem.Users.User.Domain.Entities;

<<<<<<< HEAD
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
=======
import com.webdev.productsystem.Users.User.Phone.Domain.Phone;

public class UserPhone {
    private Phone userPhone;

>>>>>>> main
}
