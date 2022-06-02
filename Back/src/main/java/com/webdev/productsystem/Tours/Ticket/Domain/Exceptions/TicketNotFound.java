package com.webdev.productsystem.Tours.Ticket.Domain.Exceptions;

public class TicketNotFound extends RuntimeException {

    public TicketNotFound(String message) {
        super(message);
    }
}
