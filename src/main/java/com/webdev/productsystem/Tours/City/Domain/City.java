package com.webdev.productsystem.Tours.City.Domain;

import com.webdev.productsystem.Tours.City.Domain.ValueObjects.CityCountry;
import com.webdev.productsystem.Tours.City.Domain.ValueObjects.CityId;
import com.webdev.productsystem.Tours.City.Domain.ValueObjects.CityName;
import com.webdev.productsystem.Tours.Tour.Domain.ValueObjects.TourBookingId;
import com.webdev.productsystem.Tours.Tour.Domain.ValueObjects.TourCity;
import com.webdev.productsystem.Tours.Tour.Domain.ValueObjects.TourId;
import com.webdev.productsystem.Tours.Tour.Domain.ValueObjects.TourName;

public class City {
    
    public CityId cityId;
    public CityName cityName;
    public CityCountry cityCountry;

    public City(CityId cityId, CityName cityName, CityCountry cityCountry) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.cityCountry = cityCountry;
    }

    public static City create(CityId cityId, CityName cityName, CityCountry cityCountry){
        City city = new City(cityId, cityName, cityCountry);
        return city;
    }

        

}
