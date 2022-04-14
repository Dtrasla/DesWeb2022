package com.webdev.productsystem.Users.User.Domain;

import com.webdev.productsystem.Users.User.Domain.Entities.*;
import com.webdev.productsystem.Users.User.Domain.Entities.UserData;
import com.webdev.productsystem.Users.User.Domain.Exceptions.AuthenticateFailed;
import com.webdev.productsystem.Users.User.Domain.ValueObjects.*;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/*TODO
 * Agregar Phone al creador
 * Modificar el UserCreateController para agregar el phone
 * */

public class User {

    private UserId userId;
    private UserEmail userEmail;
    private UserName userName
    private UserPassword password;
    private Phone userPhone;

    public User(UserId userId, UserName userName,UserEmail userEmail, Phone userPhone, UserPassword password, Optional<Object> empty) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.password = password;
        this.userPhone = userPhone;

    }

    public User(UserId userId, UserName userName,UserEmail userEmail,  UserPassword password, Optional<Object> empty) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.password = password;

    }


    public static User create(UserId userId, UserName userName ,UserEmail userEmail, UserPassword password) {
        User user = new User(userId,
                userName,
                userEmail,
                password);
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
