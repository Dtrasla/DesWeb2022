package com.webdev.productsystem.Tours.Hotel.Application.Update;

import com.webdev.productsystem.Tours.Hotel.Domain.Ports.HotelRepository;
import com.webdev.productsystem.Tours.Hotel.Domain.Services.HotelExists;
import com.webdev.productsystem.Tours.Hotel.Domain.ValueObjects.HotelName;

public class HotelUpdateName {
    private HotelRepository repository;
    private HotelExists exists;

    public HotelUpdateName(HotelRepository repository, HotelExists exists) {
        this.repository = repository;
        this.exists = exists;
    }

    public void execute(String id, String name) {
        exists.execute(id).updateName(new HotelName(name));
        repository.update(exists.execute(id));
    }
}
