package com.webdev.productsystem.Tours.Ticket.Domain.Exceptions;

public class InvalidGate extends RuntimeException{
    public InvalidGate(String message) {
        super(message);
    }
}
