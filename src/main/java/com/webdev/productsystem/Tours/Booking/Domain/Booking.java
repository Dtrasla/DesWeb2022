package com.webdev.productsystem.Tours.Booking.Domain;

import java.util.Optional;

import com.webdev.productsystem.Tours.Booking.Domain.ValueObjects.BookingId;
import com.webdev.productsystem.Tours.Hotel.Domain.Hotel;
import com.webdev.productsystem.Tours.Ticket.Domain.Tickets;

import com.webdev.productsystem.Tours.Tour.Domain.Tour;

public class Booking {

    public BookingId bookingId;
    public Optional<Hotel> hotel;
    public Optional<Tickets> ticket;
    public Optional<Tour> tour;

    public BookingId getId() {
        return bookingId;
    }

    public void setId(BookingId id) {
        this.bookingId = id;
    }

    public Booking(BookingId bookingId, Optional<Hotel> hotel, Optional<Tickets> ticket, Optional<Tour> tour) {
        this.bookingId = bookingId;
        this.hotel = hotel;
        this.ticket = ticket;
        this.tour = tour;
    }

    public static Booking create(BookingId bookingId) {
        return new Booking(bookingId, Optional.empty(), Optional.empty(), Optional.empty());
    }
}
