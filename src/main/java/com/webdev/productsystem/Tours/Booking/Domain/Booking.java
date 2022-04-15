package com.webdev.productsystem.Tours.Booking.Domain;
import com.webdev.productsystem.Tours.Hotel;
import com.webdev.productsystem.Tours.Tour;
import com.webdev.productsystem.Tours.Ticket;

import com.webdev.productsystem.Tours;

public class Booking {

    public BookingId bookingId;
    public Hotel hotel;
    public Ticket ticket;
    public Tour tour;

    public Booking(BookingId bookingId, Hotel hotel, Ticket ticket, Tour tour) {
        this.bookingId = bookingId;
        this.Hotel = hotel;
        this.Ticket =ticket;
        this.Tour = tour;
    }

    public static Booking create(BookingId bookingId,Hotel hotel, Ticket ticket, Tour tour){
        Booking booking = new Booking(bookingId, hotel, ticket, tour);
        return booking;
    }
}
