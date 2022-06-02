package com.webdev.productsystem.Tours.Tour.Application.Update;

import com.webdev.productsystem.Tours.Tour.Domain.Exceptions.TourNotFound;
import com.webdev.productsystem.Tours.Tour.Domain.Tour;
import com.webdev.productsystem.Tours.Tour.Domain.Ports.TourRepository;
import com.webdev.productsystem.Tours.Tour.Domain.ValueObjects.TourId;
import com.webdev.productsystem.Tours.Tour.Domain.ValueObjects.TourName;

public class TourNameUpdater {
    private TourRepository repository;

    public TourNameUpdater(TourRepository repository) {
        this.repository = repository;
    }

    public void execute(String id, String name) {
        validate(id);
        Tour tour = repository.find(new TourId(id)).get();
        tour.updateTourName(new TourName(name));
        repository.update(tour);
    }

    private void validate(String id) {
        checkIfExists(id);
    }

    private void checkIfExists(String id) {
        if(!repository.find(new TourId(id)).isPresent())
            throw new TourNotFound("A tour with that id doesn't exist");
    }
}
