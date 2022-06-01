package com.webdev.productsystem.Tours.Hotel.Application.AddAddress;

import com.webdev.productsystem.Tours.Hotel.Domain.Entities.HotelAddress;
import com.webdev.productsystem.Tours.Hotel.Domain.Hotel;
import com.webdev.productsystem.Tours.Hotel.Domain.Ports.HotelRepository;
import com.webdev.productsystem.Tours.Hotel.Domain.ValueObjects.HotelId;

import java.util.Optional;

public class HotelAddAddress {
    private HotelRepository repository;

    public HotelAddAddress(HotelRepository repository) {
        this.repository = repository;
    }

    public void execute(String id, String cityId, String data, String zipCode, String blockId) {
        Optional<Hotel> optionalHotel = repository.findById(new HotelId(blockId));
        if (optionalHotel.isPresent()) {
            Hotel hotel = optionalHotel.get();
            hotel.addAddress(new HotelAddress(
                    id,
                    data,
                    zipCode,
                    blockId,
                    cityId
            ));
            System.out.println("🟠 UPDATE: " + hotel.data());
            // ! Fix database update
            // this.repository.update(hotel);
        }
    }
}
