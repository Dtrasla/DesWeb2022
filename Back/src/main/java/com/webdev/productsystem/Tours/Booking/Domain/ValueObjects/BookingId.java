package com.webdev.productsystem.Tours.Booking.Domain.ValueObjects;


import com.webdev.productsystem.Shared.Domain.Aggregate.CustomUUID;

public class BookingId extends CustomUUID {
        private BookingId(){}
    
        public BookingId(String BookingId) {
            super(BookingId);
        }
    
    
    }


