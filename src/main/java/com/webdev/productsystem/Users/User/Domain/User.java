package com.webdev.productsystem.Users.User.Domain;

import com.webdev.productsystem.Users.User.Domain.Entities.UserAddress;
import com.webdev.productsystem.Users.User.Domain.Entities.UserData;
import com.webdev.productsystem.Users.User.Domain.Exceptions.AuthenticateFailed;
import com.webdev.productsystem.Users.User.Domain.ValueObjects.*;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class User {

    private UserId userId;
    private UserEmail userEmail;
    private UserPassword password;
    private UserData userData;
    private Phone userPhone;

    public User(UserId userId,  UserEmail userEmail, UserPassword password, Phone userPhone, UserData userData) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.password = password;
        this.userPhone = userPhone;
        this.userData = userData;
    }

    public static User create(UserId userId,  UserEmail userEmail, UserPassword password) {
        User user = new User(userId,
                            userEmail,
                            userPhone,
                            userData,
                            password, Optional.empty());
        return user;
    }

    public void authenticateUser(UserEmail userEmail, UserPassword password) {
        if (!(this.password.equals(password) && this.userEmail.equals(userEmail))) {
            throw new AuthenticateFailed("Credenciales inválidas");
        }
    }

    public HashMap<String, Object> data() {
        HashMap<String, Object> data = new HashMap<>() {{
            put("id", userId.value());
            put("email", userEmail.value());
//          put("");
        }};
        return data;
    }


}
