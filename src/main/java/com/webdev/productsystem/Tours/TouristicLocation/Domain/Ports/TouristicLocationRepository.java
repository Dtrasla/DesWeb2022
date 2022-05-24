package com.webdev.productsystem.Tours.TouristicLocation.Domain.Ports;



import com.webdev.productsystem.Tours.TouristicLocation.Domain.TouristicLocation;
import com.webdev.productsystem.Tours.TouristicLocation.Domain.ValueObjects.TouristicLocationId;

import java.util.List;
import java.util.Optional;

public interface TouristicLocationRepository {
    void save(TouristicLocation touristicLocation);
    void update(TouristicLocation touristicLocation);
    void delete(TouristicLocation touristicLocation);
    Optional<TouristicLocation> findById(TouristicLocationId id);
    Optional<List<TouristicLocation>> all();
}
