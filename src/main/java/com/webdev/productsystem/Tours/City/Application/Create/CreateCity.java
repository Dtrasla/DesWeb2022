package com.webdev.productsystem.Tours.City.Application.Create;
import com.webdev.productsystem.Tours.City.Domain.City;
import com.webdev.productsystem.Tours.City.Domain.Exceptions.CityAlreadyExists;
import com.webdev.productsystem.Tours.City.Domain.Ports.CityRepository;
import com.webdev.productsystem.Tours.City.Domain.ValueObjects.CityCountry;
import com.webdev.productsystem.Tours.City.Domain.ValueObjects.CityId;
import com.webdev.productsystem.Tours.City.Domain.ValueObjects.CityName;
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

public class CreateCity {

    private final CityRepository repository;


    public CreateCity(CityRepository repository) {
        this.repository = repository;
    }

    public void execute(String id,  String name, String country){
        validate(id);
        this.repository.save(City.create(new CityId(id), new CityName(name), new CityCountry(country)));

    }

    private void validate(String id){
        Optional<City> city =  repository.find(new CityId(id));

        if(city.isPresent()){
            throw new CityAlreadyExists("La ciudad con id " + id + " ya existe");
        }
    }



}
