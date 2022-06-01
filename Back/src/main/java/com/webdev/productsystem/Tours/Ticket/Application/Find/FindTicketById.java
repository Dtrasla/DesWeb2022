package com.webdev.productsystem.Tours.Ticket.Application.Find;

import com.webdev.productsystem.Tours.Ticket.Domain.Exceptions.TicketNotFound;
import com.webdev.productsystem.Tours.Ticket.Domain.Ports.TicketRepository;
import com.webdev.productsystem.Tours.Ticket.Domain.Tickets;
import com.webdev.productsystem.Tours.Ticket.Domain.ValueObjects.TicketId;

import java.util.Optional;

public class FindTicketById {

    private final TicketRepository repository;

    public FindTicketById(TicketRepository repository) {
        this.repository = repository;
    }

    public Tickets execute(String ticketId) {

        Optional<Tickets> ticketOptional = repository.find(new TicketId(ticketId));
        if (ticketOptional.isEmpty()) {

            throw new TicketNotFound("No pudimos encontrar un Tiquete con el numero" + ticketId + "por favor asegurese de ingresarlo correctamente");

        }else {

            Tickets ticket = ticketOptional.get();
            return ticket;
        }
    }
}
