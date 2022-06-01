package com.webdev.productsystem.Tours.Tour.Application.All;

import com.webdev.productsystem.Tours.Tour.Domain.Ports.TourRepository;
import com.webdev.productsystem.Tours.Tour.Domain.Tour;

import java.util.ArrayList;
import java.util.List;

public class TourFindAll {
    private TourRepository repository;

    public TourFindAll(TourRepository repository) {
        this.repository = repository;
    }

    public List<Tour> execute() {
        List<Tour> result = new ArrayList<Tour>();
        if (repository.all().isPresent())
            result = repository.all().get();
        return result;
    }
}
