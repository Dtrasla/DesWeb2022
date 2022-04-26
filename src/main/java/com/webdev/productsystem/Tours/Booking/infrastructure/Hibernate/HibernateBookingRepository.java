package com.webdev.productsystem.Tours.Booking.infrastructure.Hibernate;

import com.webdev.productsystem.Shared.Infrastruture.Hibernate.HibernateRepository;
import com.webdev.productsystem.Tours.Booking.Domain.Booking;
import com.webdev.productsystem.Tours.Booking.Domain.Ports.BookingRepository;
import com.webdev.productsystem.Tours.Booking.Domain.ValueObjects.BookingId;
import com.webdev.productsystem.Tours.Ticket.Domain.Tickets;
import com.webdev.productsystem.Tours.Ticket.Domain.ValueObjects.TicketId;
import com.webdev.productsystem.Tours.Ticket.Domain.Ports.TicketRepository;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class HibernateBookingRepository extends HibernateRepository<Booking> implements BookingRepository {

    public HibernateBookingRepository(SessionFactory sessionFactory, Class<Booking> aggregateClass) {
        super(sessionFactory, aggregateClass);
    }

    @Override
    public void save(Booking booking) {
        
    }

    @Override
    public void delete(Booking booking) {
        
    }

    @Override
    public Optional<Booking> find(BookingId id) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Booking>> all() {
        return Optional.empty();
    }

    
}
