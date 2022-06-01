package com.webdev.productsystem.Tours.TouristicLocation.Application.AddAddress;


import com.webdev.productsystem.Tours.TouristicLocation.Domain.Entities.TouristicLocationAddress;
import com.webdev.productsystem.Tours.TouristicLocation.Domain.Ports.TouristicLocationRepository;
import com.webdev.productsystem.Tours.TouristicLocation.Domain.TouristicLocation;
import com.webdev.productsystem.Tours.TouristicLocation.Domain.ValueObjects.TouristicLocationId;

public class TouristicLocationAddAddress {
    private TouristicLocationRepository repository;

    public TouristicLocationAddAddress(TouristicLocationRepository repository) {
        this.repository = repository;
    }

    public void execute(String touristicLocationId, String cityId, String id, String data, String zipCode) {
        if(repository.findById(new TouristicLocationId(touristicLocationId)).isPresent()) {
            TouristicLocation touristicLocation = repository.findById(new TouristicLocationId(touristicLocationId)).get();
            touristicLocation.addAddress(new TouristicLocationAddress(id, data, zipCode, cityId));
            this.repository.update(touristicLocation);
        }
    }
}
