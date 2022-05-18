package com.webdev.productsystem.Tours.Booking.Domain;

import java.util.HashMap;
import java.util.Optional;

import com.webdev.productsystem.Tours.Booking.Domain.ValueObjects.BookingHotel;
import com.webdev.productsystem.Tours.Booking.Domain.ValueObjects.BookingId;
import com.webdev.productsystem.Tours.Booking.Domain.ValueObjects.BookingTicket;
import com.webdev.productsystem.Tours.Booking.Domain.ValueObjects.BookingTour;
import com.webdev.productsystem.Tours.Hotel.Domain.Hotel;
import com.webdev.productsystem.Tours.Ticket.Domain.Tickets;

import com.webdev.productsystem.Tours.Tour.Domain.Tour;

public class Booking {

    public BookingId bookingId;
    public BookingHotel hotel;
    public BookingTicket ticket;
    public BookingTour tour;

    public Booking() {
    }

    public Booking(BookingId bookingId, BookingHotel hotel, BookingTicket ticket, BookingTour tour) {
        this.bookingId = bookingId;
        this.hotel = hotel;
        this.ticket = ticket;
        this.tour = tour;
    }

    public static Booking create(BookingId bookingId, BookingHotel hotel, BookingTicket ticket, BookingTour tour) {
        return new Booking(bookingId, hotel, ticket, tour);
    }

    public HashMap<String, Object> data(){
        return new HashMap<>(){{
            put("bookingId",bookingId.value());
            put("hotel",hotel.value());
            put("ticket",ticket.value());
            put("tour",tour.value());
        }};
    }
}
