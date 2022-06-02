package com.webdev.productsystem.Tours.Ticket.Application.Find;

import com.webdev.productsystem.Tours.Ticket.Domain.Ports.TicketRepository;
import com.webdev.productsystem.Tours.Ticket.Domain.Tickets;

import java.util.ArrayList;
import java.util.List;

public class TicketFindAll {

    private TicketRepository repository;

    public TicketFindAll(TicketRepository repository) {
        this.repository = repository;
    }

    public List<Tickets> execute() {
        List<Tickets> result = new ArrayList<Tickets>();
        if (repository.all().isPresent())
            result = repository.all().get();
        return result;
    }


}
