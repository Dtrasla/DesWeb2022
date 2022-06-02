package com.webdev.productsystem.Tours.Tour.Application.Create;
import com.webdev.productsystem.Tours.City.Domain.City;
import com.webdev.productsystem.Tours.City.Domain.ValueObjects.CityId;
import com.webdev.productsystem.Tours.Ticket.Domain.Exceptions.TicketAlreadyExists;
import com.webdev.productsystem.Tours.Ticket.Domain.ValueObjects.TicketDate;
import com.webdev.productsystem.Tours.Ticket.Domain.ValueObjects.TicketGate;
import com.webdev.productsystem.Tours.Ticket.Domain.ValueObjects.TicketId;
import com.webdev.productsystem.Tours.Ticket.Domain.ValueObjects.TicketSeat;
import com.webdev.productsystem.Tours.Tour.Domain.Tour;
import com.webdev.productsystem.Tours.Tour.Domain.Exceptions.TourAlreadyExists;
import com.webdev.productsystem.Tours.Tour.Domain.Ports.TourRepository;
import com.webdev.productsystem.Tours.Tour.Domain.ValueObjects.TourDate;
import com.webdev.productsystem.Tours.Tour.Domain.ValueObjects.TourCity;
import com.webdev.productsystem.Tours.Tour.Domain.ValueObjects.TourId;
import com.webdev.productsystem.Tours.Tour.Domain.ValueObjects.TourName;
import com.webdev.productsystem.Users.User.Domain.User;
import com.webdev.productsystem.Users.User.Domain.ValueObjects.UserId;

import java.util.List;
import java.util.Optional;

public class CreateTour {

    private final TourRepository repository;


    public CreateTour(TourRepository repository) {
        this.repository = repository;
    }

    public void execute(String id,  String name, List<String> citiesId, String tourBookingId){
        validate(id);
        this.repository.save(Tour.create(new TourId(id), new TourName(name), new TourCity(citiesId), new TourDate(tourBookingId)));

    }

    private void validate(String id){
        Optional<Tour> ticket =  repository.find(new TourId(id));

        if(ticket.isPresent()){
            throw new TourAlreadyExists("El tour con id " + id + " ya existe");
        }
    }



}
