package com.webdev.productsystem.Tours.Hotel.Domain.Ports;

import com.webdev.productsystem.Tours.Hotel.Domain.Hotel;
import com.webdev.productsystem.Tours.Hotel.Domain.ValueObjects.HotelId;
import com.webdev.productsystem.Tours.Hotel.Domain.ValueObjects.HotelName;

import java.util.List;
import java.util.Optional;

public interface HotelRepository {
    void save(Hotel hotel);
    void update(Hotel hotel);
    void delete(Hotel hotel);
    Optional<Hotel> findById(HotelId id);
    Optional<Hotel> findByName(HotelName name);
    Optional<List<Hotel>> all();
}
