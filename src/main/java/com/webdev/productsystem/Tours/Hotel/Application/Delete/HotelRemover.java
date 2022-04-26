package com.webdev.productsystem.Tours.Hotel.Application.Delete;

import com.webdev.productsystem.Tours.Hotel.Domain.Ports.HotelRepository;
import com.webdev.productsystem.Tours.Hotel.Domain.Services.HotelExists;

public class HotelRemover {
    private HotelRepository repository;
    private HotelExists exists;

    public HotelRemover(HotelRepository repository, HotelExists exists) {
        this.repository = repository;
        this.exists = exists;
    }

    public void execute(String id) {
        repository.delete(exists.execute(id));
    }
}
