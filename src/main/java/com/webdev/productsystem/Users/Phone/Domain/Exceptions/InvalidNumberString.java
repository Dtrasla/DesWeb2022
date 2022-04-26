package com.webdev.productsystem.Users.Phone.Domain.Exceptions;

public class InvalidNumberString extends RuntimeException{
    public InvalidNumberString(String message) {
        super(message);
    }
}
