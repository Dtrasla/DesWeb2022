package com.webdev.productsystem.Tours.TouristicLocation.Application.All;

import com.webdev.productsystem.Tours.TouristicLocation.Domain.Ports.TouristicLocationRepository;
import com.webdev.productsystem.Tours.TouristicLocation.Domain.TouristicLocation;


import java.util.ArrayList;
import java.util.List;

public class TouristicLocationFindAll {
    private TouristicLocationRepository repository;

    public TouristicLocationFindAll(TouristicLocationRepository repository) {
        this.repository = repository;
    }

    public List<TouristicLocation> execute() {
        List<TouristicLocation> result = new ArrayList<TouristicLocation>();
        if (repository.all().isPresent())
            result = repository.all().get();
        return result;
    }
}
