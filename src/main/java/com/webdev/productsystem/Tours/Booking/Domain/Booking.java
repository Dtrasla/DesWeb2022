package com.webdev.productsystem.Tours.Booking.Domain;

import com.webdev.productsystem.Tours.Booking.Domain.ValueObjects;
import com.webdev.productsystem.Tours.Hotel.Domain.ValueObjects;
import com.webdev.productsystem.Tours.Tickets.Domain.ValueObjects;
import com.webdev.productsystem.Tours.Tour.Domain.ValueObjects;

public class Booking {
    
        public BookingId BookingId;
    
        public Booking(BookingId BookingId,BookingHotels BookingHotels, BookingTickets BookingTickets, BookingTour BookingTour) {
            this.BookingId = BookingId;
            this.BookingHotels = BookingHotels;
            this.BookingTickets = BookingTickets;
            this.BookingTour = BookingTour;
            
        }
    
        public static Booking create(BookingId BookingId,BookingHotels BookingHotels, BookingTickets BookingTickets, BookingTour BookingTour){
            Booking Booking = new Booking(BookingId, BookingHotels, BookingTickets, BookingTour);
            return Booking;
        }
    
    
    
    
        

}
