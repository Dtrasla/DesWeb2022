package com.webdev.productsystem.Tours.TouristicLocation.Application.Find;


import com.webdev.productsystem.Tours.TouristicLocation.Domain.Exceptions.TouristicLocationNotExists;
import com.webdev.productsystem.Tours.TouristicLocation.Domain.Ports.TouristicLocationRepository;
import com.webdev.productsystem.Tours.TouristicLocation.Domain.TouristicLocation;
import com.webdev.productsystem.Tours.TouristicLocation.Domain.ValueObjects.TouristicLocationId;

public class TouristicLocationByIdFinder {
    private TouristicLocationRepository repository;

    public TouristicLocationByIdFinder(TouristicLocationRepository repository) { this.repository = repository; }

    public TouristicLocation execute(String id) {
        return repository.findById(new TouristicLocationId(id)).get();
    }

    private void validate(String id) {
        checkIfExists(id);
    }

    private void checkIfExists(String id) {
        if(!repository.findById(new TouristicLocationId(id)).isPresent())
            throw new TouristicLocationNotExists("A touristic location with that Id doesn't exist");
    }
}
