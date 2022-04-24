package com.webdev.productsystem.Users.Phone.Domain.Exceptions;

public class InvalidNumberLenght extends RuntimeException{
    public InvalidNumberLenght(String message) {
        super(message);
    }
}