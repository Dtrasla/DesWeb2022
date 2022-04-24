package com.webdev.productsystem.Tours.Hotel.Application.Find;

import com.webdev.productsystem.Tours.Hotel.Domain.Hotel;
import com.webdev.productsystem.Tours.Hotel.Domain.Services.HotelExists;

public class HotelFindById {
    private HotelExists exists;

    public HotelFindById(HotelExists exists) {
        this.exists = exists;
    }

    public Hotel execute(String id) {
        return exists.execute(id);
    }
}
