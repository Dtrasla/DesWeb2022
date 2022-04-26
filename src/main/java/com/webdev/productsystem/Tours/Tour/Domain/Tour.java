package com.webdev.productsystem.Tours.Tour.Domain;

import java.util.HashMap;

import com.webdev.productsystem.Tours.Tour.Domain.ValueObjects.TourDate;
import com.webdev.productsystem.Tours.Tour.Domain.ValueObjects.TourCity;
import com.webdev.productsystem.Tours.Tour.Domain.ValueObjects.TourId;
import com.webdev.productsystem.Tours.Tour.Domain.ValueObjects.TourName;

public class Tour {
    
    public TourId tourId;
    public TourName tourName;
    public TourCity tourCity;
    public TourDate tourDate;

    public Tour(TourId tourId, TourName tourName, TourCity tourCity, TourDate tourDate) {
        this.tourId = tourId;
        this.tourName = tourName;
        this.tourCity = tourCity;
        this.tourDate = tourDate;
    }

    public static Tour create(TourId tourId, TourName tourName, TourCity tourCity, TourDate tourDate){
        Tour tour = new Tour(tourId, tourName, tourCity, tourDate);
        return tour;
    }

    //private HashMap<String, Object> createTourCity() { return tourCity.data(); }

    public HashMap <String, Object> data(){
        return new HashMap<>(){{
            put("tourId", tourId.value());
            put("tourName", tourName.value());
            put("tourCity", tourCity.value());
            put("tourBookingId", tourDate.value());
        }};
    }

    public void updateTourName(TourName name){
        this.tourName = name;
    }

    public void updateTourCity(TourCity city){
        this.tourCity = city;
    }

    public void updateTourBooking(TourDate booking){
        this.tourDate = booking;
    }

}
