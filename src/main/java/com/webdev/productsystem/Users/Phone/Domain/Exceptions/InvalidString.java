package com.webdev.productsystem.Users.Phone.Domain.Exceptions;

public class InvalidString extends RuntimeException{
    public InvalidString(String message) {
        super(message);
    }
}
