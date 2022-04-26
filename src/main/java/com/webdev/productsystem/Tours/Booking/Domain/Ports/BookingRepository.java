package com.webdev.productsystem.Tours.Booking.Domain.Ports;

import com.webdev.productsystem.Tours.Booking.Domain.Booking;
import com.webdev.productsystem.Tours.Booking.Domain.ValueObjects.BookingId;
import com.webdev.productsystem.Tours.Ticket.Domain.Tickets;
import com.webdev.productsystem.Tours.Ticket.Domain.ValueObjects.TicketId;

import java.util.List;
import java.util.Optional;

public interface BookingRepository {
    void save(Booking booking);
    void update(Booking booking);
    void delete(Booking booking);
    Optional<Booking> find(BookingId id);
    Optional<List<Booking>> all();
}
