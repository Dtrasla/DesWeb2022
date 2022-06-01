package com.webdev.productsystem.Users.User.Domain.Exceptions;

public class InvalidUserName extends RuntimeException{
    public InvalidUserName(String message) {
        super(message);
    }

}
