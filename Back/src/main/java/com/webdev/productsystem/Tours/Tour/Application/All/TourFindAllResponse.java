package com.webdev.productsystem.Tours.Tour.Application.All;

import com.webdev.productsystem.Tours.Tour.Domain.Tour;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class TourFindAllResponse {
    private List<Tour> tours;

    public TourFindAllResponse(List<Tour> tours) {
        this.tours = tours;
    }

    public List<HashMap<String, Object>> response() {
        return tours.stream().map(tour -> tour.data()).collect(Collectors.toList());
    }
}
