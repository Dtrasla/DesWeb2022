package com.webdev.productsystem.Users.Phone.Domain.Exceptions;

public class PhoneInvalidCountryCodeLength extends RuntimeException{
    public PhoneInvalidCountryCodeLength(String message) {
        super(message);
    }
}
