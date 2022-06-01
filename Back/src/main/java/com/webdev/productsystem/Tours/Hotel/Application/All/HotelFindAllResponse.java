package com.webdev.productsystem.Tours.Hotel.Application.All;

import com.webdev.productsystem.Tours.Hotel.Domain.Hotel;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class HotelFindAllResponse {
    private List<Hotel> hotels;

    public HotelFindAllResponse(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    public List<HashMap<String, Object>> response() {
        return hotels.stream().map(hotel -> hotel.data()).collect(Collectors.toList());
    }
}
