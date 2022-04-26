package com.webdev.productsystem.Tours.Booking.Application.Find;

import com.webdev.productsystem.Tours.Booking.Domain.Exceptions.BookingNotFound;
import com.webdev.productsystem.Tours.Booking.Domain.Ports.BookingRepository;
import com.webdev.productsystem.Tours.Booking.Domain.Booking;
import com.webdev.productsystem.Tours.Booking.Domain.ValueObjects.BookingId;

import java.util.Optional;

public class FindBookingById {

    private final BookingRepository repository;

    public FindTicketById(BookingRepository repository) {
        this.repository = repository;
    }

    public Booking execute(String BookingId) {

        Optional<Booking> BookingOptional = repository.find(new BookingId(BookingId));
        if (ticketOptional.isEmpty()) {

            throw new BookingNotFound("No pudimos encontrar un Booking con el numero" + BookingId + "por favor asegurese de ingresarlo correctamente");

        }else {

            Booking Booking = BookingOptional.get();
            return Booking;
        }
    }
}
