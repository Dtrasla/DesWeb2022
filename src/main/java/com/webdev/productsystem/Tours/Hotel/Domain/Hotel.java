package com.webdev.productsystem.Tours.Hotel.Domain;

import com.webdev.productsystem.Tours.Hotel.Domain.ValueObjects.HotelId;
import com.webdev.productsystem.Tours.Hotel.Domain.ValueObjects.HotelName;

public class Hotel {
    public HotelId hotelId;
    public HotelName hotelName;

    public Hotel(HotelId hotelId, HotelName hotelName) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
    }

    public static Hotel create(HotelId hotelId, HotelName hotelName) {
        Hotel hotel = new Hotel(hotelId, hotelName);
        return hotel;
    }
}
