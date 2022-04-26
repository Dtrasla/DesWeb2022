package com.webdev.productsystem.Tours.City.Application.Delete;

import com.webdev.productsystem.Tours.Ticket.Domain.Exceptions.TicketNotFound;
import com.webdev.productsystem.Tours.Ticket.Domain.Ports.TicketRepository;
import com.webdev.productsystem.Tours.City.Domain.City;
import com.webdev.productsystem.Tours.City.Domain.Exceptions.CityNotFound;
import com.webdev.productsystem.Tours.City.Domain.Ports.CityRepository;
import com.webdev.productsystem.Tours.City.Domain.ValueObjects.CityId;
import com.webdev.productsystem.Tours.Ticket.Domain.Tickets;
import com.webdev.productsystem.Tours.Ticket.Domain.ValueObjects.TicketId;
import com.webdev.productsystem.Tours.Tour.Domain.Tour;
import com.webdev.productsystem.Tours.Tour.Domain.Exceptions.TourNotFound;
import com.webdev.productsystem.Tours.Tour.Domain.Ports.TourRepository;
import com.webdev.productsystem.Tours.Tour.Domain.ValueObjects.TourId;

import java.util.Optional;

public class DeleteCity {

    private CityRepository repository;

    //Busqueda del ticket

    public DeleteCity(CityRepository repository){
        this.repository= repository;
    }

    public void execute(String cityId){

        //Find the estate
        Optional<City> cityOptional = repository.find(new CityId(cityId));
        if(cityOptional.isEmpty()){

            throw new CityNotFound("No pudimos encontrar una ciudad con el numero" + cityId + "por favor asegurese de ingresarlo correctamente");

        }else{

            City city = cityOptional.get();
            repository.delete(city);
            System.out.print("Tiquete borrado exitosamente");

        }

    }








}
