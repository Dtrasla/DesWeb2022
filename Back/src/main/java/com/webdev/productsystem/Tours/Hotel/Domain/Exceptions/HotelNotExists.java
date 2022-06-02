package com.webdev.productsystem.Tours.Hotel.Domain.Exceptions;

public class HotelNotExists extends RuntimeException {
    public HotelNotExists(String message) { super(message); }
}
