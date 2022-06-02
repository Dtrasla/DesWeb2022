package com.webdev.productsystem.Tours.Booking.Domain.Exceptions;

public class BookingAlreadyExists extends RuntimeException{

        public BookingAlreadyExists(String message) {
            super(message);
        }

}
