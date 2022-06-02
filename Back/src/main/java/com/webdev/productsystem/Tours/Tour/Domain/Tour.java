package com.webdev.productsystem.Tours.Tour.Domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.webdev.productsystem.Tours.Tour.Domain.Entities.TourTouristicLocation;
import com.webdev.productsystem.Tours.Tour.Domain.ValueObjects.TourDate;
import com.webdev.productsystem.Tours.Tour.Domain.ValueObjects.TourId;
import com.webdev.productsystem.Tours.Tour.Domain.ValueObjects.TourName;

public class Tour {
    private TourId id;
    private TourName name;
    private TourDate date;
    private Optional<List<TourTouristicLocation>> touristicLocations;

    public Tour() {
    }

    public Tour(TourId id, TourName name, TourDate date, Optional<List<TourTouristicLocation>> touristicLocations) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.touristicLocations = touristicLocations;
    }

    public static Tour create(TourId id, TourName name, TourDate date) {
        Tour tour = new Tour(id, name, date, Optional.empty());
        return tour;
    }

    public HashMap<String, Object> data() {
        return new HashMap<>() {{
            put("id", id.value());
            put("name", name.value());
            put("date", date.value());
        }};
    }

    public void updateTourName(TourName name) {
        this.name = name;
    }

    public void updateTourDate(TourDate date) {
        this.date = date;
    }

    private List<HashMap<String, Object>> createTouristicLocation() {
        List<HashMap<String, Object>> list = new ArrayList<>();
        if (!touristicLocations.isEmpty())
            list = touristicLocations.get().stream().map(address -> address.data()).collect(Collectors.toList());
        return list;
    }
}
