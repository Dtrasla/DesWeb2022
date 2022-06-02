package com.webdev.productsystem.Tours.TouristicLocation.Application.Delete;


import com.webdev.productsystem.Tours.TouristicLocation.Domain.Exceptions.TouristicLocationNotExists;
import com.webdev.productsystem.Tours.TouristicLocation.Domain.Ports.TouristicLocationRepository;
import com.webdev.productsystem.Tours.TouristicLocation.Domain.ValueObjects.TouristicLocationId;

public class TouristicLocationRemover {
    private TouristicLocationRepository repository;

    public TouristicLocationRemover(TouristicLocationRepository repository) {
        this.repository = repository;
    }

    public void execute(String id) {
        validate(id);
        repository.delete(repository.findById(new TouristicLocationId(id)).get());
    }

    private void validate(String id) {
        checkIfExists(id);
    }

    private void checkIfExists(String id) {
        if(!repository.findById(new TouristicLocationId(id)).isPresent())
            throw new TouristicLocationNotExists("A touristic location with that Id doesn't exist");
    }

}
