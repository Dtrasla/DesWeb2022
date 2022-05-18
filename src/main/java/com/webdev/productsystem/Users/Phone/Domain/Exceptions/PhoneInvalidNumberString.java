package com.webdev.productsystem.Users.Phone.Domain.Exceptions;

public class PhoneInvalidNumberString extends RuntimeException{
    public PhoneInvalidNumberString(String message) {
        super(message);
    }
}
