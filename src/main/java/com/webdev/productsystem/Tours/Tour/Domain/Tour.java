package com.webdev.productsystem.Tours.Tour.Domain;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import com.webdev.productsystem.Tours.Tour.Domain.ValueObjects.TourDate;
import com.webdev.productsystem.Tours.Tour.Domain.ValueObjects.TourId;
import com.webdev.productsystem.Tours.Tour.Domain.ValueObjects.TourName;
import com.webdev.productsystem.Tours.Tour.Domain.ValueObjects.TouristicLocationId;

public class Tour {
    
    private TourId id;
    private TourName name;
    private TourDate date;
    private TouristicLocationId touristicLocationId;

    public Tour(TourId id, TourName name, TourDate date, TouristicLocationId touristicLocationId) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.touristicLocationId = touristicLocationId;
    }

    public static Tour create(TourId id, TourName name, TourDate date, TouristicLocationId touristicLocationId){
        Tour tour = new Tour(id, name, date, touristicLocationId);
        return tour;
    }

    public HashMap <String, Object> data(){
        return new HashMap<>(){{
            put("id", id.value());
            put("name", name.value());
            put("date", date.value());
            put("touristicLocationId", touristicLocationId.value());
        }};
    }

    public void updateTourName(TourName name){
        this.name = name;
    }

    public void updateTourBooking(TourDate booking){
        this.date = booking;
    }

}
