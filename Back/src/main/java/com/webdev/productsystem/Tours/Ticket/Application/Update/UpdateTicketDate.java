package com.webdev.productsystem.Tours.Ticket.Application.Update;

import com.webdev.productsystem.Tours.Ticket.Domain.Exceptions.TicketNotFound;
import com.webdev.productsystem.Tours.Ticket.Domain.Ports.TicketRepository;
import com.webdev.productsystem.Tours.Ticket.Domain.Tickets;
import com.webdev.productsystem.Tours.Ticket.Domain.ValueObjects.TicketDate;
import com.webdev.productsystem.Tours.Ticket.Domain.ValueObjects.TicketId;

import java.util.Optional;

public class UpdateTicketDate {

    private final TicketRepository repository;


    public UpdateTicketDate(TicketRepository repository) {
        this.repository = repository;
    }

    public void execute(String ticketId, String date){

        Optional<Tickets> ticketOptional = repository.find(new TicketId(ticketId));
        if (ticketOptional.isEmpty()) {

            throw new TicketNotFound("No pudimos encontrar un Tiquete con el numero" + ticketId + "por favor asegurese de ingresarlo correctamente");

        }else {

            Tickets ticket = ticketOptional.get();
            ticket.updateticketDate(new TicketDate(date));
            repository.update(ticket);
        }



    }
}
