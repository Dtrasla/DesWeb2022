package com.webdev.productsystem.Tours.Tour.Application.Create;
import com.webdev.productsystem.Tours.Tour.Domain.Tour;
import com.webdev.productsystem.Tours.Tour.Domain.Exceptions.TourAlreadyExists;
import com.webdev.productsystem.Tours.Tour.Domain.Ports.TourRepository;
import com.webdev.productsystem.Tours.Tour.Domain.ValueObjects.TourDate;
import com.webdev.productsystem.Tours.Tour.Domain.ValueObjects.TourId;
import com.webdev.productsystem.Tours.Tour.Domain.ValueObjects.TourName;
import com.webdev.productsystem.Tours.Tour.Domain.ValueObjects.TouristicLocationId;

import java.util.List;
import java.util.Optional;

public class CreateTour {

    private final TourRepository repository;


    public CreateTour(TourRepository repository) {
        this.repository = repository;
    }

    public void execute(String id,  String name, String date, String touristicLocationId){
        validate(id);
        this.repository.save(Tour.create(new TourId(id), new TourName(name), new TourDate(date), new TouristicLocationId(touristicLocationId)));

    }

    private void validate(String id){
        Optional<Tour> ticket =  repository.find(new TourId(id));

        if(ticket.isPresent()){
            throw new TourAlreadyExists("El tour con id " + id + " ya existe");
        }
    }



}
