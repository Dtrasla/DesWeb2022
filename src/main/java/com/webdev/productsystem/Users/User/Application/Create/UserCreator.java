package com.webdev.productsystem.Users.User.Application.Create;

import com.webdev.productsystem.Users.User.Domain.Ports.UserRepository;
import com.webdev.productsystem.Users.User.Domain.User;
import com.webdev.productsystem.Users.User.Domain.ValueObjects.*;
import com.webdev.productsystem.Users.User.Domain.ValueObjects.UserEmail;
import com.webdev.productsystem.Users.User.Domain.ValueObjects.UserId;
import com.webdev.productsystem.Users.User.Domain.ValueObjects.UserPassword;

public class UserCreator {

    private UserRepository repository;

    public UserCreator(UserRepository repository) {
        this.repository = repository;
    }

    public void execute(String id, String email, String password, String name, String lastName, String birthday, String gender) {
        repository.save(User.create(new UserId(id), new UserEmail(email), new UserPassword(password), new UserName(name),
                new UserLastName(lastName), new UserBirthday(birthday), new UserGender(gender)));
    }
}
