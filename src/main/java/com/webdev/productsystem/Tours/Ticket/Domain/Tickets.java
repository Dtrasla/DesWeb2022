package com.webdev.productsystem.Tours.Ticket.Domain;

import com.webdev.productsystem.Tours.Ticket.Domain.ValueObjects.*;

import java.util.HashMap;

public class Tickets {

    private TicketId id;
    private TicketGate gate;
    private TicketSeat seat;
    private TicketDate date;
    private UserId userId;
    private OriginCityId originCityId;
    private DestinationCityId destinationCityId;

    public Tickets(TicketId id, TicketGate gate, TicketSeat seat, TicketDate date, UserId userId, OriginCityId originCityId, DestinationCityId destinationCityId) {
        this.id = id;
        this.gate = gate;
        this.seat = seat;
        this.date = date;
        this.userId = userId;
        this.originCityId = originCityId;
        this.destinationCityId = destinationCityId;
    }

    public static Tickets create(TicketId ticketId, TicketGate ticketGate, TicketSeat ticketSeat, TicketDate ticketDate, OriginCityId originCityId, DestinationCityId destinationCityId, UserId userId) {
        return new Tickets(ticketId, ticketGate, ticketSeat, ticketDate, userId, originCityId, destinationCityId);
    }

    public HashMap<String, Object> data() {
        return new HashMap<>() {{
            put("id", id.value());
            put("gate", gate.value());
            put("seat", seat.value());
            put("date", date.value());
            put("originCityId", originCityId.value());
            put("destinationCityId", destinationCityId.value());
            put("userId", userId.value());
        }};
    }

    public void updateticketGate(TicketGate gate) {
        this.gate = gate;
    }

    public void updateticketSeat(TicketSeat seat) {
        this.seat = seat;
    }

    public void updateticketDate(TicketDate date) {
        this.date = date;
    }

}
