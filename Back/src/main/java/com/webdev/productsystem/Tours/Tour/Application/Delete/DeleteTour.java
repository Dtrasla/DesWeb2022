package com.webdev.productsystem.Tours.Tour.Application.Delete;

import com.webdev.productsystem.Tours.Ticket.Domain.Exceptions.TicketNotFound;
import com.webdev.productsystem.Tours.Ticket.Domain.Ports.TicketRepository;
import com.webdev.productsystem.Tours.Ticket.Domain.Tickets;
import com.webdev.productsystem.Tours.Ticket.Domain.ValueObjects.TicketId;
import com.webdev.productsystem.Tours.Tour.Domain.Tour;
import com.webdev.productsystem.Tours.Tour.Domain.Exceptions.TourNotFound;
import com.webdev.productsystem.Tours.Tour.Domain.Ports.TourRepository;
import com.webdev.productsystem.Tours.Tour.Domain.ValueObjects.TourId;

import java.util.Optional;

public class DeleteTour {

    private TourRepository repository;

    //Busqueda del ticket

    public DeleteTour(TourRepository repository){
        this.repository= repository;
    }

    public void execute(String tourId){

        //Find the estate
        Optional<Tour> tourOptional = repository.find(new TourId(tourId));
        if(tourOptional.isEmpty()){

            throw new TourNotFound("No pudimos encontrar un Tiquete con el numero" + tourId + "por favor asegurese de ingresarlo correctamente");

        }else{

            Tour tour = tourOptional.get();
            repository.delete(tour);
            System.out.print("Tiquete borrado exitosamente");

        }

    }








}
