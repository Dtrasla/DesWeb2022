package com.webdev.productsystem.Tours.TouristicLocation.Application.Update;


import com.webdev.productsystem.Tours.TouristicLocation.Domain.Exceptions.TouristicLocationNotExists;
import com.webdev.productsystem.Tours.TouristicLocation.Domain.Ports.TouristicLocationRepository;
import com.webdev.productsystem.Tours.TouristicLocation.Domain.TouristicLocation;
import com.webdev.productsystem.Tours.TouristicLocation.Domain.ValueObjects.TouristicLocationId;
import com.webdev.productsystem.Tours.TouristicLocation.Domain.ValueObjects.TouristicLocationName;

public class TouristicLocationNameUpdater {
    private TouristicLocationRepository repository;

    public TouristicLocationNameUpdater(TouristicLocationRepository repository) {
        this.repository = repository;
    }

    public void execute(String id, String name) {
        validate(id);
        TouristicLocation touristicLocation = repository.findById(new TouristicLocationId(id)).get();
        touristicLocation.updateName(new TouristicLocationName(name));
        repository.update(touristicLocation);
    }

    private void validate(String id) {
        checkIfExists(id);
    }

    private void checkIfExists(String id) {
        if(!repository.findById(new TouristicLocationId(id)).isPresent())
            throw new TouristicLocationNotExists("A touristic location with that Id doesn't exist");
    }
}
