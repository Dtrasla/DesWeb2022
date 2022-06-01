package com.webdev.productsystem.Tours.TouristicLocation.Application.Create;


import com.webdev.productsystem.Tours.TouristicLocation.Domain.Exceptions.TouristicLocationAlreadyExists;
import com.webdev.productsystem.Tours.TouristicLocation.Domain.Ports.TouristicLocationRepository;
import com.webdev.productsystem.Tours.TouristicLocation.Domain.TouristicLocation;
import com.webdev.productsystem.Tours.TouristicLocation.Domain.ValueObjects.TouristicLocationId;
import com.webdev.productsystem.Tours.TouristicLocation.Domain.ValueObjects.TouristicLocationName;

public class TouristicLocationCreator {
    private TouristicLocationRepository repository;

    public TouristicLocationCreator(TouristicLocationRepository repository) {
        this.repository = repository;
    }

    public void execute(String id, String name) {
        validate(id);
        this.repository.save(TouristicLocation.create(new TouristicLocationId(id), new TouristicLocationName(name)));
    }

    private void validate(String id) {
        checkIfAlreadyExists(id);
    }

    private void checkIfAlreadyExists(String id) {
        if(repository.findById(new TouristicLocationId(id)).isPresent())
            throw new TouristicLocationAlreadyExists("A touristic location with that Id already exists");
    }
}
