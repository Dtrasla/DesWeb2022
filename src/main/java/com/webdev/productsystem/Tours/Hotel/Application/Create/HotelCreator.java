package com.webdev.productsystem.Tours.Hotel.Application.Create;

import com.webdev.productsystem.Tours.Hotel.Domain.Exceptions.HotelAlreadyExists;
import com.webdev.productsystem.Tours.Hotel.Domain.Hotel;
import com.webdev.productsystem.Tours.Hotel.Domain.Ports.HotelRepository;
import com.webdev.productsystem.Tours.Hotel.Domain.ValueObjects.HotelId;
import com.webdev.productsystem.Tours.Hotel.Domain.ValueObjects.HotelName;

public class HotelCreator {
    private HotelRepository repository;

    public HotelCreator(HotelRepository repository) {
        this.repository = repository;
    }

    public void execute(String id, String name) {
        validate(id);
        this.repository.save(Hotel.create(new HotelId(id), new HotelName(name)));
    }

    private void validate(String id) {
        checkIfAlreadyExists(id);
    }

    private void checkIfAlreadyExists(String id) {
        if(repository.findById(new HotelId(id)).isPresent())
            throw new HotelAlreadyExists("A hotel with that Id already exists");
    }
}
