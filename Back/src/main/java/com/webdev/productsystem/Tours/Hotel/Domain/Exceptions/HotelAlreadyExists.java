package com.webdev.productsystem.Tours.Hotel.Domain.Exceptions;

public class HotelAlreadyExists extends RuntimeException {
    public HotelAlreadyExists(String message) { super(message); }
}
