package com.webdev.productsystem.Tours.Tour.Domain.Exceptions;

public class TourNotFound extends RuntimeException {

    public TourNotFound(String message) {
        super(message);
    }
}
