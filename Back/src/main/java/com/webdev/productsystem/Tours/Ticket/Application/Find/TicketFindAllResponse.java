package com.webdev.productsystem.Tours.Ticket.Application.Find;

import com.webdev.productsystem.Tours.Hotel.Domain.Hotel;
import com.webdev.productsystem.Tours.Ticket.Domain.Tickets;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class TicketFindAllResponse {

    private List<Tickets> tickets;

    public TicketFindAllResponse(List<Tickets> hotels) {
        this.tickets = hotels;
    }

    public List<HashMap<String, Object>> response() {
        return tickets.stream().map(tickets -> tickets.data()).collect(Collectors.toList());
    }
}
