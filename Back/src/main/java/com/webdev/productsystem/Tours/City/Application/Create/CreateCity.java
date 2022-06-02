package com.webdev.productsystem.Tours.City.Application.Create;
import com.webdev.productsystem.Tours.City.Domain.City;
import com.webdev.productsystem.Tours.City.Domain.Exceptions.CityAlreadyExists;
import com.webdev.productsystem.Tours.City.Domain.Ports.CityRepository;
import com.webdev.productsystem.Tours.City.Domain.ValueObjects.CityCountry;
import com.webdev.productsystem.Tours.City.Domain.ValueObjects.CityId;
import com.webdev.productsystem.Tours.City.Domain.ValueObjects.CityName;
import com.webdev.productsystem.Tours.City.Domain.ValueObjects.TouristicLocationId;

import java.util.Optional;

public class CreateCity {

    private final CityRepository repository;


    public CreateCity(CityRepository repository) {
        this.repository = repository;
    }

    public void execute(String id,  String name, String country,String touristicLocationId){
        validate(id);
        this.repository.save(City.create(new CityId(id), new CityName(name), new CityCountry(country), new TouristicLocationId(touristicLocationId)));

    }

    private void validate(String id){
        Optional<City> city =  repository.find(new CityId(id));

        if(city.isPresent()){
            throw new CityAlreadyExists("La ciudad con id " + id + " ya existe");
        }
    }



}