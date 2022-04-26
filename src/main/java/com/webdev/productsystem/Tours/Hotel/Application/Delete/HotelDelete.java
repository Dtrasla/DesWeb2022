package com.webdev.productsystem.Tours.Hotel.Application.Delete;

import com.webdev.productsystem.Tours.Hotel.Domain.Exceptions.HotelNotExists;
import com.webdev.productsystem.Tours.Hotel.Domain.Hotel;
import com.webdev.productsystem.Tours.Hotel.Domain.Ports.HotelRepository;
import com.webdev.productsystem.Tours.Hotel.Domain.Services.HotelExists;
import com.webdev.productsystem.Tours.Hotel.Domain.ValueObjects.HotelId;

import java.util.Optional;

public class HotelDelete {
    private HotelRepository repository;
    private HotelExists exists;

    public HotelDelete(HotelRepository repository, HotelExists exists) {
        this.repository = repository;
        this.exists = exists;
    }

    public void execute(String id) {
        repository.delete(exists.execute(id));
    }
}
