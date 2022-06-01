package com.webdev.productsystem.Tours.Booking.Application.All;

import com.webdev.productsystem.Tours.Booking.Domain.Booking;
import com.webdev.productsystem.Tours.Booking.Domain.Ports.BookingRepository;

import java.util.ArrayList;
import java.util.List;

public class BookingFindAll {
    private BookingRepository repository;

    public BookingFindAll(BookingRepository repository) {
        this.repository = repository;
    }

    public List<Booking> execute() {
        List<Booking> result = new ArrayList<Booking>();
        if (repository.all().isPresent())
            result = repository.all().get();
        return result;
    }
}
