package com.webdev.productsystem.Users.Phone.Domain.Exceptions;

public class PhoneInvalidCountryCodeString extends RuntimeException{
    public PhoneInvalidCountryCodeString(String message) {
        super(message);
    }
}
