package com.webdev.productsystem.Tours.Tour.Application.Update;

import com.webdev.productsystem.Tours.Ticket.Domain.Exceptions.TicketNotFound;
import com.webdev.productsystem.Tours.Ticket.Domain.ValueObjects.TicketDate;
import com.webdev.productsystem.Tours.Ticket.Domain.ValueObjects.TicketId;
import com.webdev.productsystem.Tours.Tour.Domain.Tour;
import com.webdev.productsystem.Tours.Tour.Domain.Exceptions.TourCityInvalid;
import com.webdev.productsystem.Tours.Tour.Domain.Ports.TourRepository;
import com.webdev.productsystem.Tours.Tour.Domain.ValueObjects.TourCity;
import com.webdev.productsystem.Tours.Tour.Domain.ValueObjects.TourId;
import com.webdev.productsystem.Tours.Tour.Domain.ValueObjects.TourName;

import java.util.List;
import java.util.Optional;

public class UpdateTourCity {

    private final TourRepository repository;


    public UpdateTourCity(TourRepository repository) {
        this.repository = repository;
    }

    public void execute(String tourId, List<String> cities){

        Optional<Tour> tourOptional = repository.find(new TourId(tourId));
        if (tourOptional.isEmpty()) {

            throw new TourCityInvalid("No pudimos encontrar una ciudad en el tour con el numero" + tourId + "por favor asegurese de ingresarlo correctamente");

        }else {

            Tour tour = tourOptional.get();
            tour.updateTourCity(new TourCity(cities));
            repository.update(tour);
        }



    }
}
