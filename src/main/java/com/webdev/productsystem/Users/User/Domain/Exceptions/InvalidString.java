package com.webdev.productsystem.Users.User.Domain.Exceptions;

public class InvalidString extends RuntimeException{
    public InvalidString(String message) {
        super(message);
    }
}
