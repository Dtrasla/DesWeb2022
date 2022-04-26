package com.webdev.productsystem.Users.Phone.Domain.Exceptions;

public class InvalidNumberLength extends RuntimeException{
    public InvalidNumberLength(String message) {
        super(message);
    }
}