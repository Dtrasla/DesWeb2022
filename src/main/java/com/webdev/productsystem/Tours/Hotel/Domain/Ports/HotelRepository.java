package com.webdev.productsystem.Tours.Hotel.Domain.Ports;

import com.webdev.productsystem.Tours.Hotel.Domain.Hotel;
import com.webdev.productsystem.Tours.Hotel.Domain.ValueObjects.HotelId;

import java.util.List;
import java.util.Optional;

public interface HotelRepository {
    void save(Hotel hotel);
    void update(Hotel hotel);
    void delete(Hotel hotel);
    Optional<Hotel> find(HotelId id);
    Optional<List<Hotel>> all();
}
