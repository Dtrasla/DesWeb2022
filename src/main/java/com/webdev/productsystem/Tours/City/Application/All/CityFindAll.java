package com.webdev.productsystem.Tours.City.Application.All;

import com.webdev.productsystem.Tours.City.Domain.City;
import com.webdev.productsystem.Tours.City.Domain.Ports.CityRepository;
import com.webdev.productsystem.Tours.Hotel.Domain.Hotel;
import com.webdev.productsystem.Tours.Hotel.Domain.Ports.HotelRepository;

import java.util.ArrayList;
import java.util.List;

public class CityFindAll {
    private CityRepository repository;

    public CityFindAll(CityRepository repository) {
        this.repository = repository;
    }

    public List<City> execute() {
        List<City> result = new ArrayList<City>();
        if (repository.all().isPresent())
            result = repository.all().get();
        return result;
    }
}
