package com.webdev.productsystem.Users.User.Application.Find;

import com.webdev.productsystem.Users.User.Domain.Exceptions.UserNotFound;
import com.webdev.productsystem.Users.User.Domain.Ports.UserRepository;
import com.webdev.productsystem.Users.User.Domain.User;
import com.webdev.productsystem.Users.User.Domain.ValueObjects.UserId;

public class UserByIdFinder {
    private UserRepository repository;

    public UserByIdFinder(UserRepository repository) { this.repository = repository; }

    public User execute(String id) {
        validate(id);
        return repository.find(new UserId(id)).get();
    }

    private void validate(String id) {
        checkIfExists(id);
    }

    private void checkIfExists(String id) {
        if(!repository.find(new UserId(id)).isPresent())
            throw new UserNotFound("User not found");
    }
}
