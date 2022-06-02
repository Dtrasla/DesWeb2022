package com.webdev.productsystem.Tours.Ticket.Domain.Exceptions;

public class InvalidSeat extends RuntimeException{
    public InvalidSeat(String message) {
        super(message);
    }
}
