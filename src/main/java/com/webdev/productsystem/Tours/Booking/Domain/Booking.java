package com.webdev.productsystem.Tours.Booking.Domain;

import com.webdev.productsystem.Tours.Booking.Domain.ValueObjects.BookingId;
import com.webdev.productsystem.Tours.Hotel.Domain.Hotel;
import com.webdev.productsystem.Tours.Ticket.Domain.Tickets;

import com.webdev.productsystem.Tours.Tour.Domain.Tour;

public class Booking {

    public BookingId bookingId;
    public Hotel hotel;
    public Tickets ticket;
    public Tour tour;

    public Booking(BookingId bookingId, Hotel hotel, Tickets ticket, Tour tour) {
        this.bookingId = bookingId;
        this.hotel = hotel;
        this.ticket = ticket;
        this.tour = tour;
    }

    public static Booking create(BookingId bookingId, Hotel hotel, Tickets ticket, Tour tour) {
        return new Booking(bookingId, hotel, ticket, tour);
    }
}
