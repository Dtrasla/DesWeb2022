package com.webdev.productsystem.Users.User.Application.Create;

import com.webdev.productsystem.Users.User.Domain.Ports.UserRepository;
import com.webdev.productsystem.Users.User.Domain.Ports.UserSenderEmail;
import com.webdev.productsystem.Users.User.Domain.User;
import com.webdev.productsystem.Users.User.Domain.ValueObjects.*;

public class UserCreator {

    private UserRepository repository;

    public UserCreator(UserRepository repository) {
        this.repository = repository;
    }

    public void execute(String userId, String userName ,String userEmail, String password, String userLastName, String userBirthday, String userGender) {
        User user = User.create(new UserId(userId), new UserName(userName),new UserEmail(userEmail), new UserPassword(password),
                new UserLastName(userLastName), new UserGender(userGender), new UserBirthday(userBirthday));
        repository.save(user);
    }
}
