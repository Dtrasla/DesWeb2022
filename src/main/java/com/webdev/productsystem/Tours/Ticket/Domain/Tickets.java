package com.webdev.productsystem.Tours.Ticket.Domain;

import com.webdev.productsystem.Tours.City.Domain.City;
import com.webdev.productsystem.Tours.Ticket.Domain.ValueObjects.TicketId;
import com.webdev.productsystem.Users.User.Domain.ValueObjects.UserId;
import com.webdev.productsystem.Tours.Ticket.Domain.ValueObjects.TicketDate;
import com.webdev.productsystem.Tours.Ticket.Domain.ValueObjects.TicketGate;
import com.webdev.productsystem.Tours.Ticket.Domain.ValueObjects.TicketSeat;
import com.webdev.productsystem.Tours.Tour.Domain.ValueObjects.TourBookingId;
import com.webdev.productsystem.Tours.Tour.Domain.ValueObjects.TourCity;
import com.webdev.productsystem.Tours.Tour.Domain.ValueObjects.TourId;
import com.webdev.productsystem.Tours.Tour.Domain.ValueObjects.TourName;
import com.webdev.productsystem.Users.User.Domain.ValueObjects.UserId;

public class Tickets {

    public TicketGate ticketGate;
    public TicketSeat ticketSeat;
    public TicketDate ticketDate;
    public TicketId ticketId;
    public UserId userId;
    public City originCity;
    public City destinationCity;

    public Tickets(TicketId ticketId, TicketGate ticketGate, TicketSeat ticketSeat, TicketDate ticketDate, City originCity, City destinationCity, UserId userId) {

        this.ticketId = ticketId;
        this.ticketGate = ticketGate;
        this.ticketSeat = ticketSeat;
        this.ticketDate = ticketDate;
        this.originCity = originCity;
        this.destinationCity = destinationCity;
        this.userId = userId;
    }

    public static Tickets create(TicketId ticketId, TicketGate ticketGate, TicketSeat ticketSeat, TicketDate ticketDate, City originCity, City destinationCity,  UserId userId){
        Tickets ticket = new Tickets(ticketId,ticketGate, ticketSeat, ticketDate, originCity, destinationCity, userId);
        return ticket;
    }



}
