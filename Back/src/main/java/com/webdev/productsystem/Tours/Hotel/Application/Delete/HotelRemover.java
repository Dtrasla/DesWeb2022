package com.webdev.productsystem.Tours.Hotel.Application.Delete;

import com.webdev.productsystem.Tours.Hotel.Domain.Exceptions.HotelAlreadyExists;
import com.webdev.productsystem.Tours.Hotel.Domain.Exceptions.HotelNotExists;
import com.webdev.productsystem.Tours.Hotel.Domain.Ports.HotelRepository;
import com.webdev.productsystem.Tours.Hotel.Domain.ValueObjects.HotelId;

public class HotelRemover {
    private HotelRepository repository;

    public HotelRemover(HotelRepository repository) {
        this.repository = repository;
    }

    public void execute(String id) {
        validate(id);
        repository.delete(repository.findById(new HotelId(id)).get());
    }

    private void validate(String id) {
        checkIfExists(id);
    }

    private void checkIfExists(String id) {
        if(!repository.findById(new HotelId(id)).isPresent())
            throw new HotelNotExists("A hotel with that Id doesn't exist");
    }
}
