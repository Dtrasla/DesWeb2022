package com.webdev.productsystem.Tours.Booking.Domain;

import java.util.HashMap;

import com.webdev.productsystem.Tours.Booking.Domain.ValueObjects.BookingHotel;
import com.webdev.productsystem.Tours.Booking.Domain.ValueObjects.BookingId;
import com.webdev.productsystem.Tours.Booking.Domain.ValueObjects.BookingTicket;


public class Booking {

    public BookingId bookingId;
    public BookingHotel hotel;
    public BookingTicket ticket;


    public Booking(BookingId bookingId, BookingHotel hotel, BookingTicket ticket) {
        this.bookingId = bookingId;
        this.hotel = hotel;
        this.ticket = ticket;

    }

    public static Booking create(BookingId bookingId, BookingHotel hotel, BookingTicket ticket) {
        return new Booking(bookingId, hotel, ticket);
    }

    public HashMap<String, Object> data(){
        return new HashMap<>(){{
            put("bookingId",bookingId.value());
            put("hotel",hotel.value());
            put("ticket",ticket.value());

        }};
    }
}
