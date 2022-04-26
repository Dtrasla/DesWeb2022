package com.webdev.productsystem.Tours.Tour.Domain.Exceptions;

public class TourNameInvalid extends RuntimeException {

    public TourNameInvalid(String message) {
        super(message);
    }
}
