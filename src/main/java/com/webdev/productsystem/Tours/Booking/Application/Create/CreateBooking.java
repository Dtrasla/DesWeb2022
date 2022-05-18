package com.webdev.productsystem.Tours.Booking.Application.Create;
import com.webdev.productsystem.Tours.City.Domain.City;
import com.webdev.productsystem.Tours.City.Domain.ValueObjects.CityId;
import com.webdev.productsystem.Tours.Booking.Domain.Booking;
import com.webdev.productsystem.Tours.Booking.Domain.Exceptions.BookingAlreadyExists;
import com.webdev.productsystem.Tours.Booking.Domain.Ports.BookingRepository;
import com.webdev.productsystem.Tours.Booking.Domain.ValueObjects.BookingHotel;
import com.webdev.productsystem.Tours.Booking.Domain.ValueObjects.BookingId;
import com.webdev.productsystem.Tours.Booking.Domain.ValueObjects.BookingTicket;
import com.webdev.productsystem.Tours.Booking.Domain.ValueObjects.BookingTour;
import com.webdev.productsystem.Tours.Ticket.Domain.Tickets;
import com.webdev.productsystem.Tours.Ticket.Domain.ValueObjects.TicketId;
import com.webdev.productsystem.Users.User.Domain.User;
import com.webdev.productsystem.Users.User.Domain.ValueObjects.UserId;
import com.webdev.productsystem.Tours.Hotel.Domain.ValueObjects.HotelId;
import com.webdev.productsystem.Tours.Tour.Domain.ValueObjects.TourId;

import java.util.List;
import java.util.Optional;

public class CreateBooking {

    private final BookingRepository repository;


    public CreateBooking(BookingRepository repository) {
        this.repository = repository;
    }
    public void execute(String id, String ticket, List<String> hotelsId, String tour){
        validate(id);
        this.repository.save(Booking.create(
                                            new BookingId(id),
                                            new BookingHotel(hotelsId),
                                            new BookingTicket(ticket),
                                            new BookingTour(tour)
                                            ));
        
    }

    private void validate(String id){
        Optional<Booking> Booking =  repository.find(new BookingId(id));

        if(Booking.isPresent()){
            throw new BookingAlreadyExists("El booking con id " + id + " ya existe");
        }
    }



}
