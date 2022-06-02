package com.webdev.productsystem.Tours.City.Domain.Exceptions;

public class CityNotFound extends RuntimeException {
    public CityNotFound(String message) {
        super(message);
    }
}
