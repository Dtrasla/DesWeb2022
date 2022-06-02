package com.webdev.productsystem.Tours.Tour.Application.Update;

import com.webdev.productsystem.Tours.Ticket.Domain.Exceptions.TicketNotFound;
import com.webdev.productsystem.Tours.Ticket.Domain.ValueObjects.TicketDate;
import com.webdev.productsystem.Tours.Ticket.Domain.ValueObjects.TicketId;
import com.webdev.productsystem.Tours.Tour.Domain.Tour;
import com.webdev.productsystem.Tours.Tour.Domain.Exceptions.TourNameInvalid;
import com.webdev.productsystem.Tours.Tour.Domain.Ports.TourRepository;
import com.webdev.productsystem.Tours.Tour.Domain.ValueObjects.TourId;
import com.webdev.productsystem.Tours.Tour.Domain.ValueObjects.TourName;

import java.util.Optional;

public class UpdateTourName {

    private final TourRepository repository;


    public UpdateTourName(TourRepository repository) {
        this.repository = repository;
    }

    public void execute(String tourId, String name){

        Optional<Tour> tourOptional = repository.find(new TourId(tourId));
        if (tourOptional.isEmpty()) {

            throw new TourNameInvalid("El nombre" + name + " es invalido");

        }else {

            Tour tour = tourOptional.get();
            tour.updateTourName(new TourName(name));
            repository.update(tour);
        }



    }
}
