package com.webdev.productsystem.Tours.Tour.Application.AddTouristicLocation;

import com.webdev.productsystem.Tours.Tour.Domain.Entities.TourTouristicLocation;
import com.webdev.productsystem.Tours.Tour.Domain.Ports.TourRepository;
import com.webdev.productsystem.Tours.Tour.Domain.Tour;
import com.webdev.productsystem.Tours.Tour.Domain.ValueObjects.TourId;

import java.util.Optional;

public class TourAddTouristicLocation {
    private TourRepository repository;

    public TourAddTouristicLocation(TourRepository repository) {
        this.repository = repository;
    }

    public void execute(String id, String name, String tourId) {
        Optional<Tour> optionalUser = repository.find(new TourId(tourId));
        if(optionalUser.isPresent()) {
            Tour tour = optionalUser.get();
            tour.addTouristicLocation(new TourTouristicLocation(id, name, tourId));
            System.out.println("🟣 " + tour.data().toString());
            this.repository.update(tour);
        }
    }
}
