package com.webdev.productsystem.Users.User.Phone.Domain.Exceptions;

public class LenghtInvalid extends RuntimeException{
    public LenghtInvalid(String message) {
        super(message);
    }
}