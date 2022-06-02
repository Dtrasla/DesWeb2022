package com.webdev.productsystem.Tours.Tour.Domain.Exceptions;

public class TourBookingInvalid extends RuntimeException {

    public TourBookingInvalid(String message) {
        super(message);
    }
}
