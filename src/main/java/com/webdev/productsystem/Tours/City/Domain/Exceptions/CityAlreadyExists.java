package com.webdev.productsystem.Tours.City.Domain.Exceptions;

public class CityAlreadyExists extends RuntimeException {

    public CityAlreadyExists(String message) {
        super(message);
    }
}