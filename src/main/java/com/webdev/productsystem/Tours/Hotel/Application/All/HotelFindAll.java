package com.webdev.productsystem.Tours.Hotel.Application.All;

import com.webdev.productsystem.Tours.Hotel.Domain.Hotel;
import com.webdev.productsystem.Tours.Hotel.Domain.Ports.HotelRepository;

import java.util.ArrayList;
import java.util.List;

public class HotelFindAll {
    private HotelRepository repository;

    public HotelFindAll(HotelRepository repository) {
        this.repository = repository;
    }

    public List<Hotel> execute() {
        List<Hotel> result = new ArrayList<Hotel>();
        if (repository.all().isPresent())
            result = repository.all().get();
        return result;
    }
}
