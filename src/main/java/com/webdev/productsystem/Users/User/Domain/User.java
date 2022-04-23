package com.webdev.productsystem.Users.User.Domain;

<<<<<<< HEAD
import com.webdev.productsystem.Users.User.Domain.Entities.*;
=======
import com.webdev.productsystem.Users.User.Domain.Entities.UserData;
import com.webdev.productsystem.Users.User.Domain.Entities.UserPhone;
>>>>>>> main
import com.webdev.productsystem.Users.User.Domain.Exceptions.AuthenticateFailed;
import com.webdev.productsystem.Users.User.Domain.ValueObjects.*;
import com.webdev.productsystem.Users.User.Phone.Domain.Phone;

import java.util.HashMap;

public class User {
    private UserId id;
    private UserEmail email;
    private UserPassword password;
<<<<<<< HEAD
    private UserName name;
    private UserLastName lastName;
    private UserBirthday birthday;
    private UserGender gender;
    private UserPhone phone;

    public User(UserId id, UserEmail email, UserPassword password, UserName name,
                UserLastName lastName, UserBirthday birthday, UserGender gender, UserPhone phone) {
        this.id = id;
        this.email = email;
=======
    private UserData userData;
    private UserPhone userPhone;

    public User(UserId userId, UserEmail userEmail, UserPassword password, UserPhone userPhone, UserData userData) {
        this.userId = userId;
        this.userEmail = userEmail;
>>>>>>> main
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.birthday = birthday;
        this.gender = gender;
        this.phone = phone;
    }

<<<<<<< HEAD
    private HashMap<String, Object> createPhone() { return phone.data(); }
=======
    public User(UserId userId, UserEmail userEmail, UserPassword password) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.password = password;
    }

    public static User create(UserId userId, UserEmail userEmail, UserPassword password) {
        User user = new User(userId, userEmail, password);
        return user;
    }
>>>>>>> main

    public User create(UserId id, UserEmail email, UserPassword password, UserName name,
                       UserLastName lastName, UserBirthday birthday, UserGender gender, UserPhone phone) {
        return new User(id, email, password, name, lastName, birthday, gender, phone);
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
