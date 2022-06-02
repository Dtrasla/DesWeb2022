package com.webdev.productsystem.Tours.City.Application.Find;

import java.util.Optional;

import com.webdev.productsystem.Tours.City.Domain.City;
import com.webdev.productsystem.Tours.City.Domain.Exceptions.CityNotFound;
import com.webdev.productsystem.Tours.City.Domain.Ports.CityRepository;
import com.webdev.productsystem.Tours.City.Domain.ValueObjects.CityId;

public class FindCityById {
    private final CityRepository repository;

    public FindCityById(CityRepository repository) {
        this.repository = repository;
    }

    public City execute(String cityId) {

        Optional<City> cityOptional = repository.find(new CityId(cityId));
        if (cityOptional.isEmpty()) {
            //CAMBIAR
            throw new CityNotFound("No pudimos encontrar un Tour con el numero" + cityId + "por favor asegurese de ingresarlo correctamente");

        }else {

            City city = cityOptional.get();
            return city;
        }
    }
}
