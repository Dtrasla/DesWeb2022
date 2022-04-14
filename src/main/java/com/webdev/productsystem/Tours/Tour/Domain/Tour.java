package com.webdev.productsystem.Tours.Tour.Domain;

import java.util.HashMap;

import com.webdev.productsystem.Tours.Tour.Domain.Entities.TourCity;
import com.webdev.productsystem.Tours.Tour.Domain.ValueObjects.TourBookingId;
import com.webdev.productsystem.Tours.Tour.Domain.ValueObjects.TourId;
import com.webdev.productsystem.Tours.Tour.Domain.ValueObjects.TourName;

public class Tour {
    
    public TourId tourId;
    public TourName tourName;
    public TourCity tourCity;
    public TourBookingId tourBookingId;

    public Tour(TourId tourId, TourName tourName, TourCity tourCity, TourBookingId tourBookingId) {
        this.tourId = tourId;
        this.tourName = tourName;
        this.tourCity = tourCity;
        this.tourBookingId = tourBookingId;
    }

    public static Tour create(TourId tourId, TourName tourName, TourCity tourCity, TourBookingId tourBookingId){
        Tour tour = new Tour(tourId, tourName, tourCity, tourBookingId);
        return tour;
    }

    private HashMap<String, Object> createTourCity() { return tourCity.data(); }

    public HashMap <String, Object> data(){
        return new HashMap<>(){{
            put("tourId", tourId);
            put("tourName", tourName);
            put("tourCity", tourCity);
            put("tourBookingId", tourBookingId);
        }};
    }

}
