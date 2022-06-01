package com.webdev.productsystem.Tours.Hotel.Application.AddAddress;

import com.webdev.productsystem.Tours.Hotel.Domain.Entities.HotelAddress;
import com.webdev.productsystem.Tours.Hotel.Domain.Hotel;
import com.webdev.productsystem.Tours.Hotel.Domain.Ports.HotelRepository;
import com.webdev.productsystem.Tours.Hotel.Domain.ValueObjects.HotelId;

public class HotelAddAddress {
    private HotelRepository repository;

    public HotelAddAddress(HotelRepository repository) {
        this.repository = repository;
    }

    public void execute(String hotelId, String cityId, String id, String data, String zipCode) {
        if(repository.findById(new HotelId(hotelId)).isPresent()) {
            Hotel hotel = repository.findById(new HotelId(hotelId)).get();
            hotel.addAddress(new HotelAddress(id, data, zipCode, cityId));
            this.repository.update(hotel);
        }
    }
}
