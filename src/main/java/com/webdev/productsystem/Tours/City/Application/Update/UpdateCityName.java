package com.webdev.productsystem.Tours.City.Application.Update;

import com.webdev.productsystem.Tours.City.Domain.City;
import com.webdev.productsystem.Tours.City.Domain.Exceptions.CityNameInvalid;
import com.webdev.productsystem.Tours.City.Domain.Ports.CityRepository;
import com.webdev.productsystem.Tours.City.Domain.ValueObjects.CityId;
import com.webdev.productsystem.Tours.City.Domain.ValueObjects.CityName;
import com.webdev.productsystem.Tours.Ticket.Domain.Exceptions.TicketNotFound;
import com.webdev.productsystem.Tours.Ticket.Domain.ValueObjects.TicketDate;
import com.webdev.productsystem.Tours.Ticket.Domain.ValueObjects.TicketId;
import com.webdev.productsystem.Tours.Tour.Domain.Tour;
import com.webdev.productsystem.Tours.Tour.Domain.Exceptions.TourNameInvalid;
import com.webdev.productsystem.Tours.Tour.Domain.Ports.TourRepository;
import com.webdev.productsystem.Tours.Tour.Domain.ValueObjects.TourId;
import com.webdev.productsystem.Tours.Tour.Domain.ValueObjects.TourName;

import java.util.Optional;

public class UpdateCityName {

    private final CityRepository repository;


    public UpdateCityName(CityRepository repository) {
        this.repository = repository;
    }

    public void execute(String cityId, String name){

        Optional<City> cityOptional = repository.find(new CityId(cityId));
        if (cityOptional.isEmpty()) {

            throw new CityNameInvalid("El nombre" + name + " es invalido");

        }else {

            City city = cityOptional.get();
            city.updateCityName(new CityName(name));
            repository.update(city);
        }



    }
}
