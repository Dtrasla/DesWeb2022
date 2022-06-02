package com.webdev.productsystem.Users.Phone.Domain.Exceptions;

public class PhoneExistingIdValue extends RuntimeException{
    public PhoneExistingIdValue(String message) {
        super(message);
    }
}
