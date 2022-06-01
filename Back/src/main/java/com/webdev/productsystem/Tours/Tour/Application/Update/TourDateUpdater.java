package com.webdev.productsystem.Tours.Tour.Application.Update;

import com.webdev.productsystem.Tours.Tour.Domain.Exceptions.TourNotFound;
import com.webdev.productsystem.Tours.Tour.Domain.Ports.TourRepository;
import com.webdev.productsystem.Tours.Tour.Domain.Tour;
import com.webdev.productsystem.Tours.Tour.Domain.ValueObjects.TourDate;
import com.webdev.productsystem.Tours.Tour.Domain.ValueObjects.TourId;

public class TourDateUpdater {
    private TourRepository repository;

    public TourDateUpdater(TourRepository repository) {
        this.repository = repository;
    }

    public void execute(String id, String date) {
        validate(id);
        Tour tour = repository.find(new TourId(id)).get();
        tour.updateTourDate(new TourDate(date));
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
