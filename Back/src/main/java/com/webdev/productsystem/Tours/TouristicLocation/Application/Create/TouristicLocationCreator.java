package com.webdev.productsystem.Tours.TouristicLocation.Application.Create;


import com.webdev.productsystem.Shared.Domain.Bus.Event.EventBus;
import com.webdev.productsystem.Tours.TouristicLocation.Domain.Exceptions.TouristicLocationAlreadyExists;
import com.webdev.productsystem.Tours.TouristicLocation.Domain.Ports.TouristicLocationRepository;
import com.webdev.productsystem.Tours.TouristicLocation.Domain.TouristicLocation;
import com.webdev.productsystem.Tours.TouristicLocation.Domain.ValueObjects.TourId;
import com.webdev.productsystem.Tours.TouristicLocation.Domain.ValueObjects.TouristicLocationId;
import com.webdev.productsystem.Tours.TouristicLocation.Domain.ValueObjects.TouristicLocationName;

public class TouristicLocationCreator {
    private TouristicLocationRepository repository;
    private EventBus eventBus;

    public TouristicLocationCreator(TouristicLocationRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus = eventBus;
    }

    public void execute(String id, String name, String tourId) {
        validate(id);
        TouristicLocation touristicLocation = TouristicLocation.create(new TouristicLocationId(id), new TouristicLocationName(name), new TourId(tourId));
        this.repository.save(touristicLocation);
        this.eventBus.publish(touristicLocation.pullDomainEvents());
    }

    private void validate(String id) {
        checkIfAlreadyExists(id);
    }

    private void checkIfAlreadyExists(String id) {
        if(repository.findById(new TouristicLocationId(id)).isPresent())
            throw new TouristicLocationAlreadyExists("A touristic location with that Id already exists");
    }
}
