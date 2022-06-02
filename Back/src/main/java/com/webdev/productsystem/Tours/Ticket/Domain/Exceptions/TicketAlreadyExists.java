package com.webdev.productsystem.Tours.Ticket.Domain.Exceptions;

public class TicketAlreadyExists extends RuntimeException{

        public TicketAlreadyExists(String message) {
            super(message);
        }

}
