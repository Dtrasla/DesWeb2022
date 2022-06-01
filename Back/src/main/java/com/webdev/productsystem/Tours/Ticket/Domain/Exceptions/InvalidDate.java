package com.webdev.productsystem.Tours.Ticket.Domain.Exceptions;

public class InvalidDate extends RuntimeException{
    public InvalidDate(String message) {
        super(message);
    }

}
