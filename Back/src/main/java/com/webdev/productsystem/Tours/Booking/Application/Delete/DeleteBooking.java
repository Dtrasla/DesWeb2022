package com.webdev.productsystem.Tours.Booking.Application.Delete;

import com.webdev.productsystem.Tours.Booking.Domain.Exceptions.BookingNotFound;
import com.webdev.productsystem.Tours.Booking.Domain.Ports.BookingRepository;
import com.webdev.productsystem.Tours.Booking.Domain.Booking;
import com.webdev.productsystem.Tours.Booking.Domain.ValueObjects.BookingId;

import java.util.Optional;

public class DeleteBooking {

    private BookingRepository repository;

    //Busqueda del Booking

    public DeleteBooking(BookingRepository repository){
        this.repository= repository;
    }

    public void execute(String BookingId){

        //Find the estate
        Optional<Booking> BookingOptional = repository.find(new BookingId(BookingId));
        if(BookingOptional.isEmpty()){

            throw new BookingNotFound("No pudimos encontrar un Booking con el numero" + BookingId + "por favor asegurese de ingresarlo correctamente");

        }else{

            Booking Booking = BookingOptional.get();
            repository.delete(Booking);
            System.out.print("Booking borrado exitosamente");

        }

    }








}
