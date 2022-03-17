package com.webdev.productsystem.Tours.City.Domain;

import com.webdev.productsystem.Tours.Tour.Domain.ValueObjects.TourBookingId;
import com.webdev.productsystem.Tours.Tour.Domain.ValueObjects.TourCity;
import com.webdev.productsystem.Tours.Tour.Domain.ValueObjects.TourId;
import com.webdev.productsystem.Tours.Tour.Domain.ValueObjects.TourName;

public class City {
    
    public TourId tourId;
    public TourName tourName;
    public TourCity tourCity;
    public TourBookingId tourBookingId;

    public City(TourId tourId, TourName tourName, TourCity tourCity, TourBookingId tourBookingId) {
        this.tourId = tourId;
        this.tourName = tourName;
        this.tourCity = tourCity;
        this.tourBookingId = tourBookingId;
    }

    public static City create(TourId tourId, TourName tourName, TourCity tourCity, TourBookingId tourBookingId){
        City tour = new City(tourId, tourName, tourCity, tourBookingId);
        return tour;
    }

        

}
