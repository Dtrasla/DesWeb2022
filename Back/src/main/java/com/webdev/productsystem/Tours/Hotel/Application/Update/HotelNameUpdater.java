package com.webdev.productsystem.Tours.Hotel.Application.Update;

import com.webdev.productsystem.Tours.Hotel.Domain.Exceptions.HotelNotExists;
import com.webdev.productsystem.Tours.Hotel.Domain.Hotel;
import com.webdev.productsystem.Tours.Hotel.Domain.Ports.HotelRepository;
import com.webdev.productsystem.Tours.Hotel.Domain.ValueObjects.HotelId;
import com.webdev.productsystem.Tours.Hotel.Domain.ValueObjects.HotelName;

public class HotelNameUpdater {
    private HotelRepository repository;

    public HotelNameUpdater(HotelRepository repository) {
        this.repository = repository;
    }

    public void execute(String id, String name) {
        validate(id);
        Hotel hotel = repository.findById(new HotelId(id)).get();
        hotel.updateName(new HotelName(name));
        repository.update(hotel);
    }

    private void validate(String id) {
        checkIfExists(id);
    }

    private void checkIfExists(String id) {
        if(!repository.findById(new HotelId(id)).isPresent())
            throw new HotelNotExists("A hotel with that Id doesn't exist");
    }
}