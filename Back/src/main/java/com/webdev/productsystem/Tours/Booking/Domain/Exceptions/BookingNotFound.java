package com.webdev.productsystem.Tours.Booking.Domain.Exceptions;

public class BookingNotFound extends RuntimeException {

    public BookingNotFound(String message) {
        super(message);
    }
}
