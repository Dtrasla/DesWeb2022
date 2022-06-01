package com.webdev.productsystem.Tours.Booking.Application.All;

import com.webdev.productsystem.Tours.Booking.Domain.Booking;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class BookingFindAllResponse {
    private List<Booking> bookings;

    public BookingFindAllResponse(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public List<HashMap<String, Object>> response() {
        return bookings.stream().map(booking -> booking.data()).collect(Collectors.toList());
    }
}
