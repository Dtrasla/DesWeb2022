package com.webdev.productsystem.Tours.TouristicLocation.Application.All;

import com.webdev.productsystem.Tours.TouristicLocation.Domain.TouristicLocation;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class TouristicLocationFindAllResponse {
    private List<TouristicLocation> touristicLocations;

    public TouristicLocationFindAllResponse(List<TouristicLocation> touristicLocations) {
        this.touristicLocations = touristicLocations;
    }

    public List<HashMap<String, Object>> response() {
        return touristicLocations.stream().map(location -> location.data()).collect(Collectors.toList());
    }
}
