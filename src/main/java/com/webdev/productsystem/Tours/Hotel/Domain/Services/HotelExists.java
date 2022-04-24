package com.webdev.productsystem.Tours.Hotel.Domain.Services;

import com.webdev.productsystem.Tours.Hotel.Domain.Exceptions.HotelNotExists;
import com.webdev.productsystem.Tours.Hotel.Domain.Hotel;
import com.webdev.productsystem.Tours.Hotel.Domain.Ports.HotelRepository;
import com.webdev.productsystem.Tours.Hotel.Domain.ValueObjects.HotelId;

public class HotelExists {
    private HotelRepository repository;

    public HotelExists(HotelRepository repository) {
        this.repository = repository;
    }

    public Hotel execute(String id) {
        if(!repository.findById(new HotelId(id)).isPresent())
            throw new HotelNotExists("That hotel doesn't exist");
        return repository.findById(new HotelId(id)).get();
    }
}
