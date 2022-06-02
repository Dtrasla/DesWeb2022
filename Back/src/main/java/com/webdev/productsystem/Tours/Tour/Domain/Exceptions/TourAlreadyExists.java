package com.webdev.productsystem.Tours.Tour.Domain.Exceptions;

public class TourAlreadyExists extends RuntimeException {

    public TourAlreadyExists(String message) {
        super(message);
    }
}
