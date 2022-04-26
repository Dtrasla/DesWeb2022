package com.webdev.productsystem.Tours.City.Application.Find;

import com.webdev.productsystem.Tours.City.Domain.City;
import com.webdev.productsystem.Tours.City.Domain.Exceptions.CityNotFound;
import com.webdev.productsystem.Tours.City.Domain.Ports.CityRepository;
import com.webdev.productsystem.Tours.City.Domain.ValueObjects.CityId;
import com.webdev.productsystem.Tours.Ticket.Domain.Exceptions.TicketNotFound;
import com.webdev.productsystem.Tours.Ticket.Domain.ValueObjects.TicketId;
import com.webdev.productsystem.Tours.Tour.Domain.Tour;
import com.webdev.productsystem.Tours.Tour.Domain.Exceptions.TourNotFound;
import com.webdev.productsystem.Tours.Tour.Domain.Ports.TourRepository;
import com.webdev.productsystem.Tours.Tour.Domain.ValueObjects.TourId;

import java.util.Optional;

public class FindCityById {

    private final CityRepository repository;

    public FindCityById(CityRepository repository) {
        this.repository = repository;
    }

    public City execute(String cityId) {

        Optional<City> cityOptional = repository.find(new CityId(cityId));
        if (cityOptional.isEmpty()) {
            //CAMBIAR
            throw new CityNotFound("No pudimos encontrar una ciudad con el numero" + cityId + "por favor asegurese de ingresarlo correctamente");

        }else {

            City city = cityOptional.get();
            return city;
        }
    }
}
