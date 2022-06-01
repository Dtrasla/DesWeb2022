package com.webdev.productsystem.Tours.Ticket.Application.Update;

import com.webdev.productsystem.Tours.Ticket.Domain.Exceptions.TicketNotFound;
import com.webdev.productsystem.Tours.Ticket.Domain.Ports.TicketRepository;
import com.webdev.productsystem.Tours.Ticket.Domain.Tickets;
import com.webdev.productsystem.Tours.Ticket.Domain.ValueObjects.TicketDate;
import com.webdev.productsystem.Tours.Ticket.Domain.ValueObjects.TicketGate;
import com.webdev.productsystem.Tours.Ticket.Domain.ValueObjects.TicketId;
import com.webdev.productsystem.Tours.Ticket.Domain.ValueObjects.TicketSeat;

import java.util.Optional;

public class UpdateTicketSeat {

    private final TicketRepository repository;


    public UpdateTicketSeat(TicketRepository repository) {
        this.repository = repository;
    }

    public void execute(String ticketId, int seat){

        Optional<Tickets> ticketOptional = repository.find(new TicketId(ticketId));
        if (ticketOptional.isEmpty()) {

            throw new TicketNotFound("No pudimos encontrar un Tiquete con el numero" + ticketId + "por favor asegurese de ingresarlo correctamente");

        }else {

            Tickets ticket = ticketOptional.get();
            ticket.updateticketSeat(new TicketSeat(seat));
            repository.update(ticket);
        }



    }
}
