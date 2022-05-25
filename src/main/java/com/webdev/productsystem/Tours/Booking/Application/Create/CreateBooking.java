package com.webdev.productsystem.Tours.Booking.Application.Create;
import com.webdev.productsystem.Tours.Booking.Domain.Booking;
import com.webdev.productsystem.Tours.Booking.Domain.Exceptions.BookingAlreadyExists;
import com.webdev.productsystem.Tours.Booking.Domain.Ports.BookingRepository;
import com.webdev.productsystem.Tours.Booking.Domain.ValueObjects.BookingHotel;
import com.webdev.productsystem.Tours.Booking.Domain.ValueObjects.BookingId;
import com.webdev.productsystem.Tours.Booking.Domain.ValueObjects.BookingTicket;

import java.util.Optional;

public class CreateBooking {

    private final BookingRepository repository;


    public CreateBooking(BookingRepository repository) {
        this.repository = repository;
    }
    public void execute(String id,String hotelsId, String ticket){
        validate(id);
        this.repository.save(Booking.create(
                                            new BookingId(id),
                                            new BookingHotel(hotelsId),
                                            new BookingTicket(ticket)

                                            ));
        
    }

    private void validate(String id){
        Optional<Booking> Booking =  repository.find(new BookingId(id));

        if(Booking.isPresent()){
            throw new BookingAlreadyExists("El booking con id " + id + " ya existe");
        }
    }



}
