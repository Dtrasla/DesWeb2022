package com.webdev.productsystem.Tours.Tour.Application.Find;

import com.webdev.productsystem.Tours.Hotel.Domain.Exceptions.HotelNotExists;
import com.webdev.productsystem.Tours.Hotel.Domain.ValueObjects.HotelId;
import com.webdev.productsystem.Tours.Ticket.Domain.Exceptions.TicketNotFound;
import com.webdev.productsystem.Tours.Ticket.Domain.ValueObjects.TicketId;
import com.webdev.productsystem.Tours.Tour.Domain.Tour;
import com.webdev.productsystem.Tours.Tour.Domain.Exceptions.TourNotFound;
import com.webdev.productsystem.Tours.Tour.Domain.Ports.TourRepository;
import com.webdev.productsystem.Tours.Tour.Domain.ValueObjects.TourId;

import java.util.Optional;

public class FindTourById {

    private final TourRepository repository;

    public FindTourById(TourRepository repository) {
        this.repository = repository;
    }

    public Tour execute(String id) {
        validate(id);
        return repository.find(new TourId(id)).get();
    }

    private void validate(String id) {
        checkIfExists(id);
    }

    private void checkIfExists(String id) {
        if(!repository.find(new TourId(id)).isPresent())
            throw new TourNotFound("A tour with that id doesn't exist");
    }
}
