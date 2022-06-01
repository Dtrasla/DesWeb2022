package com.webdev.productsystem.Tours.Ticket.Domain.Ports;

import com.webdev.productsystem.Tours.Ticket.Domain.Tickets;
import com.webdev.productsystem.Tours.Ticket.Domain.ValueObjects.TicketId;

import java.util.List;
import java.util.Optional;

public interface TicketRepository {
    void save(Tickets ticket);
    void update(Tickets ticket);
    void delete(Tickets ticket);
    Optional<Tickets> find(TicketId id);
    Optional<List<Tickets>> all();
}
