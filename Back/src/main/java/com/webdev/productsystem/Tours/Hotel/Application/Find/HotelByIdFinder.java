package com.webdev.productsystem.Tours.Hotel.Application.Find;

import com.webdev.productsystem.Tours.Hotel.Domain.Exceptions.HotelNotExists;
import com.webdev.productsystem.Tours.Hotel.Domain.Hotel;
import com.webdev.productsystem.Tours.Hotel.Domain.Ports.HotelRepository;
import com.webdev.productsystem.Tours.Hotel.Domain.ValueObjects.HotelId;

public class HotelByIdFinder {
    private HotelRepository repository;

    public HotelByIdFinder(HotelRepository repository) { this.repository = repository; }

    public Hotel execute(String id) {
        return repository.findById(new HotelId(id)).get();
    }

    private void validate(String id) {
        checkIfExists(id);
    }

    private void checkIfExists(String id) {
        if(!repository.findById(new HotelId(id)).isPresent())
            throw new HotelNotExists("A hotel with that Id doesn't exist");
    }

}