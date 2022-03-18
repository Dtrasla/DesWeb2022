package com.webdev.productsystem.Tours.Booking.Domain;

import com.webdev.productsystem.Tours.Booking.Domain.ValueObjects.BookingHotels;
import com.webdev.productsystem.Tours.Booking.Domain.ValueObjects.BookingId;
import com.webdev.productsystem.Tours.Booking.Domain.ValueObjects.BookingTickets;
import com.webdev.productsystem.Tours.Booking.Domain.ValueObjects.BookingTour;

public class Booking {

    public BookingId bookingId;
    public BookingHotels bookingHotels;
    public BookingTickets bookingTickets;
    public BookingTour bookingTour;

    public Booking(BookingId bookingId, BookingHotels bookingHotels, BookingTickets bookingTickets, BookingTour bookingTour) {
        this.bookingId = bookingId;
        this.bookingHotels = bookingHotels;
        this.bookingTickets = bookingTickets;
        this.bookingTour = bookingTour;
    }

    public static Booking create(BookingId bookingId, BookingHotels bookingHotels, BookingTickets bookingTickets, BookingTour bookingTour){
        Booking booking = new Booking(bookingId, bookingHotels, bookingTickets, bookingTour);
        return booking;
    }
}
