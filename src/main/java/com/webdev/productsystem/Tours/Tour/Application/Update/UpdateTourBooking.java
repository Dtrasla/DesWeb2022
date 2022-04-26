package com.webdev.productsystem.Tours.Tour.Application.Update;

import com.webdev.productsystem.Tours.Ticket.Domain.Exceptions.TicketNotFound;
import com.webdev.productsystem.Tours.Ticket.Domain.ValueObjects.TicketDate;
import com.webdev.productsystem.Tours.Ticket.Domain.ValueObjects.TicketId;
import com.webdev.productsystem.Tours.Tour.Domain.Tour;
import com.webdev.productsystem.Tours.Tour.Domain.Exceptions.TourBookingInvalid;
import com.webdev.productsystem.Tours.Tour.Domain.Ports.TourRepository;
import com.webdev.productsystem.Tours.Tour.Domain.ValueObjects.TourDate;
import com.webdev.productsystem.Tours.Tour.Domain.ValueObjects.TourId;
import com.webdev.productsystem.Tours.Tour.Domain.ValueObjects.TourName;

import java.util.Optional;

public class UpdateTourBooking {

    private final TourRepository repository;


    public UpdateTourBooking(TourRepository repository) {
        this.repository = repository;
    }

    public void execute(String tourId, String booking){

        Optional<Tour> tourOptional = repository.find(new TourId(tourId));
        if (tourOptional.isEmpty()) {

            throw new TourBookingInvalid("La reserva con el numero " + tourId + " es invalida");

        }else {

            Tour tour = tourOptional.get();
            tour.updateTourBooking(new TourDate(booking));
            repository.update(tour);
        }



    }
}
