package com.webdev.productsystem.Users.Phone.Domain.Exceptions;

public class PhoneNotFound extends RuntimeException{
    public PhoneNotFound(String message) {
        super(message);
    }
}
