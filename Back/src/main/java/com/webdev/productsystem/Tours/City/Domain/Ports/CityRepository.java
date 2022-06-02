package com.webdev.productsystem.Tours.City.Domain.Ports;

import com.webdev.productsystem.Tours.City.Domain.City;
import com.webdev.productsystem.Tours.City.Domain.ValueObjects.CityId;

import java.util.List;
import java.util.Optional;

public interface CityRepository {
    void save(City city);
    void update(City city);
    void delete(City city);
    Optional<City> find(CityId id);
    Optional<List<City>> all();
}
