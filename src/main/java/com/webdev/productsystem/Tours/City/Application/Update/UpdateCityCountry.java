package com.webdev.productsystem.Tours.City.Application.Update;

import com.webdev.productsystem.Tours.City.Domain.City;
import com.webdev.productsystem.Tours.City.Domain.Exceptions.CityCountryInvalid;
import com.webdev.productsystem.Tours.City.Domain.Ports.CityRepository;
import com.webdev.productsystem.Tours.City.Domain.ValueObjects.CityCountry;
import com.webdev.productsystem.Tours.City.Domain.ValueObjects.CityId;
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

public class UpdateCityCountry {

    private final CityRepository repository;


    public UpdateCityCountry(CityRepository repository) {
        this.repository = repository;
    }

    public void execute(String cityId, String name){

        Optional<City> cityOptional = repository.find(new CityId(cityId));
        if (cityOptional.isEmpty()) {

            throw new CityCountryInvalid("El pais el numero " + cityId + " es invalida");

        }else {

            City city = cityOptional.get();
            city.updateCityCountry(new CityCountry(name));
            repository.update(city);
        }



    }
}
