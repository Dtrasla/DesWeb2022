package com.webdev.productsystem.Tours.Tour.Domain.Ports;

import com.webdev.productsystem.Tours.Tour.Domain.Tour;
import com.webdev.productsystem.Tours.Tour.Domain.ValueObjects.TourId;

import java.util.List;
import java.util.Optional;

public interface TourRepository {
    void save(Tour tour);
    void update(Tour tour);
    void delete(Tour tour);
    Optional<Tour> find(TourId id);
    Optional<List<Tour>> all();
}
