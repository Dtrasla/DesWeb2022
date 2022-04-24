package com.webdev.productsystem.Users.Phone.Domain.Exceptions;

public class PhoneExistingValue extends RuntimeException{
    public PhoneExistingValue(String message) {
        super(message);
    }
}
