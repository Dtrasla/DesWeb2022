package com.webdev.productsystem.Users.Phone.Domain.Exceptions;

public class PhoneInvalidNumberLength extends RuntimeException{
    public PhoneInvalidNumberLength(String message) {
        super(message);
    }
}