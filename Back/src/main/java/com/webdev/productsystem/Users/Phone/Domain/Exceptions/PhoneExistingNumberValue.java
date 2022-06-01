package com.webdev.productsystem.Users.Phone.Domain.Exceptions;

public class PhoneExistingNumberValue extends RuntimeException{
    public PhoneExistingNumberValue(String message) {
        super(message);
    }
}
