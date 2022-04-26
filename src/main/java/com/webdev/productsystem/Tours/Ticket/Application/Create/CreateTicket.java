package com.webdev.productsystem.Tours.Ticket.Application.Create;

import com.webdev.productsystem.Tours.Ticket.Domain.Exceptions.TicketAlreadyExists;
import com.webdev.productsystem.Tours.Ticket.Domain.Ports.TicketRepository;
import com.webdev.productsystem.Tours.Ticket.Domain.Tickets;
import com.webdev.productsystem.Tours.Ticket.Domain.ValueObjects.*;

import java.util.Optional;

public class CreateTicket {

    private final TicketRepository repository;


    public CreateTicket(TicketRepository repository) {
        this.repository = repository;
    }

    public void execute(String id, String date, int gate, int seat, String OriginCity, String DestinationCity, String userId){
        validate(id);
        this.repository.save(Tickets.create(new TicketId(id), new TicketGate(gate), new TicketSeat(seat), new TicketDate(date), new OriginCityId(OriginCity), new DestinationCityId(DestinationCity), new UserId(userId)));
    }

    private void validate(String id){

        Optional<Tickets> ticket =  repository.find(new TicketId(id));
        if(ticket.isPresent())
            throw new TicketAlreadyExists("A ticket with that id already exists");

    }



}
