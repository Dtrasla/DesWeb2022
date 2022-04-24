package com.webdev.productsystem.Tours.Ticket.Application.Create;
import com.webdev.productsystem.Tours.City.Domain.City;
import com.webdev.productsystem.Tours.City.Domain.ValueObjects.CityId;
import com.webdev.productsystem.Tours.Ticket.Domain.Exceptions.TicketAlreadyExists;
import com.webdev.productsystem.Tours.Ticket.Domain.Ports.TicketRepository;
import com.webdev.productsystem.Tours.Ticket.Domain.Tickets;
import com.webdev.productsystem.Tours.Ticket.Domain.ValueObjects.TicketDate;
import com.webdev.productsystem.Tours.Ticket.Domain.ValueObjects.TicketGate;
import com.webdev.productsystem.Tours.Ticket.Domain.ValueObjects.TicketId;
import com.webdev.productsystem.Tours.Ticket.Domain.ValueObjects.TicketSeat;
import com.webdev.productsystem.Users.User.Domain.User;
import com.webdev.productsystem.Users.User.Domain.ValueObjects.UserId;

import java.util.Optional;

public class CreateTicket {

    private final TicketRepository repository;


    public CreateTicket(TicketRepository repository) {
        this.repository = repository;
    }

    public void execute(String id, String date, int gate, int seat, String OriginCity, String DestinationCity, String userId){
        validate(id);
        this.repository.save(Tickets.create(new TicketId(id), new TicketGate(gate), new TicketSeat(seat), new TicketDate(date),  new CityId(OriginCity), new CityId(DestinationCity), new UserId(userId)));

    }

    private void validate(String id){
        Optional<Tickets> ticket =  repository.find(new TicketId(id));

        if(ticket.isPresent()){
            throw new TicketAlreadyExists("El tiquete de viaje con id " + id + " ya existe");
        }
    }



}
