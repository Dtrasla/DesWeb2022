package com.webdev.productsystem.Tours.City.Application.Update;

import com.webdev.productsystem.Tours.Address.Domain.Address;
import com.webdev.productsystem.Tours.Address.Domain.Excpetions.AddressNotExists;
import com.webdev.productsystem.Tours.Address.Domain.Ports.AddressRepository;
import com.webdev.productsystem.Tours.Address.Domain.ValueObjects.AddressData;
import com.webdev.productsystem.Tours.Address.Domain.ValueObjects.AddressId;

import com.webdev.productsystem.Tours.City.Domain.City;
import com.webdev.productsystem.Tours.City.Domain.Exceptions.CityNotFound;
import com.webdev.productsystem.Tours.City.Domain.Ports.CityRepository;
import com.webdev.productsystem.Tours.City.Domain.ValueObjects.CityId;
import com.webdev.productsystem.Tours.City.Domain.ValueObjects.CityName;

public class CityNameUpdater {
    private CityRepository repository;

    public CityNameUpdater(CityRepository repository) {
        this.repository = repository;
    }

    public void execute(String id, String data) {
        validate(id);
        City city = repository.find(new CityId(id)).get();
        city.updateCityName(new CityName(data));
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
