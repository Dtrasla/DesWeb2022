package com.webdev.productsystem.Users.User.Domain;

import com.webdev.productsystem.Shared.Domain.Aggregate.AggregateRoot;
import com.webdev.productsystem.Users.User.Domain.Entities.UserPhone;
import com.webdev.productsystem.Users.User.Domain.ValueObjects.*;

import java.util.HashMap;
import java.util.Optional;

public class User extends AggregateRoot {
    private UserId id;
    private UserEmail email;
    private UserPassword password;
    private UserName name;
    private UserLastName lastName;
    private UserBirthday birthday;
    private UserGender gender;
    private Optional<UserPhone> phone;

    public User(UserId id, UserEmail email, UserPassword password, UserName name,
                UserLastName lastName, UserBirthday birthday, UserGender gender, Optional<UserPhone> phone) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.birthday = birthday;
        this.gender = gender;
        this.phone = phone;
    }

    public User() {
        super();
    }

    private HashMap<String, Object> createPhone() {
        return phone.get().data();
    }

    public HashMap<String, Object> addPhone(UserPhone phone) {
        this.phone = Optional.ofNullable(phone);
        return phone.data();
    }

    public static User create(UserId id, UserEmail email, UserPassword password, UserName name,
                              UserLastName lastName, UserBirthday birthday, UserGender gender) {
        return new User(id, email, password, name, lastName, birthday, gender, Optional.empty());
    }

    public void authenticateUser(UserEmail userEmail, UserPassword password) {
        if (!(this.password.equals(password) && this.email.equals(userEmail))) {
            System.out.println("Invalid credentials");
        }
    }

    public HashMap<String, Object> data() {
        return new HashMap<>() {{
            put("id", id.value());
            put("email", email.value());
            put("password", password.value());
            put("name", name.value());
            put("lastName", lastName.value());
            put("birthday", birthday.value());
            put("gender", gender.value());
            put("phone", createPhone());
        }};
    }
}
