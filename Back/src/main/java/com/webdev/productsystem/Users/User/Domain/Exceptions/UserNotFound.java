package com.webdev.productsystem.Users.User.Domain.Exceptions;

public class UserNotFound extends RuntimeException{
    public UserNotFound(String message) {
        super(message);
    }
}