package com.webdev.productsystem.Tours.City.Application.All;

import com.webdev.productsystem.Tours.City.Domain.City;
import com.webdev.productsystem.Tours.Hotel.Domain.Hotel;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class CityFindAllResponse {
    private List<City> cities;

    public CityFindAllResponse(List<City> cities) {
        this.cities = cities;
    }

    public List<HashMap<String, Object>> response() {
        return cities.stream().map(city -> city.data()).collect(Collectors.toList());
    }
}
