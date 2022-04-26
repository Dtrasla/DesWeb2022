package com.webdev.productsystem.Tours.Tour.Application.Find;

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

    public Tour execute(String tourId) {

        Optional<Tour> tourOptional = repository.find(new TourId(tourId));
        if (tourOptional.isEmpty()) {
            //CAMBIAR
            throw new TourNotFound("No pudimos encontrar un Tour con el numero" + tourId + "por favor asegurese de ingresarlo correctamente");

        }else {

            Tour tour = tourOptional.get();
            return tour;
        }
    }
}
