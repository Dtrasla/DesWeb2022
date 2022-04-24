package com.webdev.productsystem.Tours.Hotel.Application.Create;

import com.webdev.productsystem.Tours.Hotel.Domain.Exceptions.HotelAlreadyExists;
import com.webdev.productsystem.Tours.Hotel.Domain.Hotel;
import com.webdev.productsystem.Tours.Hotel.Domain.Ports.HotelRepository;
import com.webdev.productsystem.Tours.Hotel.Domain.ValueObjects.HotelId;
import com.webdev.productsystem.Tours.Hotel.Domain.ValueObjects.HotelName;

public class HotelCreate {
    private HotelRepository repository;

    public HotelCreate(HotelRepository repository) {
        this.repository = repository;
    }

    public void execute(String id, String name) {
        validate(name);
        this.repository.save(Hotel.create(new HotelId(id), new HotelName(name)));
    }

    private void validate(String name) {
        alreadyExists(name);
    }

    private void alreadyExists(String name) {
        if(repository.findByName(new HotelName(name)).isPresent())
            throw new HotelAlreadyExists("Hotel with name " + name + " already exists");
    }
}
