package com.webdev.productsystem.Tours.City.Application.Update;

import com.webdev.productsystem.Tours.Address.Domain.Excpetions.AddressNotExists;
import com.webdev.productsystem.Tours.City.Domain.City;
import com.webdev.productsystem.Tours.City.Domain.Exceptions.CityNotFound;
import com.webdev.productsystem.Tours.City.Domain.Ports.CityRepository;
import com.webdev.productsystem.Tours.City.Domain.ValueObjects.CityCountry;
import com.webdev.productsystem.Tours.City.Domain.ValueObjects.CityId;
import com.webdev.productsystem.Tours.City.Domain.ValueObjects.CityName;

public class CityCountryUpdater {
    private CityRepository repository;

    public CityCountryUpdater(CityRepository repository) {
        this.repository = repository;
    }

    public void execute(String id, String data) {
        validate(id);
        City city = repository.find(new CityId(id)).get();
        city.updateCityCountry(new CityCountry(data));
        repository.update(city);
    }

    private void validate(String id) {
        checkIfExists(id);
    }

    private void checkIfExists(String id) {
        if(!repository.find(new CityId(id)).isPresent())
            throw new CityNotFound("A city with that Id doesn't exist");
    }
}
