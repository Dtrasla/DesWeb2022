package com.webdev.productsystem.Tours.Tour.Infrastructure.Hibernate;

import com.webdev.productsystem.Shared.Infrastruture.Hibernate.HibernateRepository;
import com.webdev.productsystem.Tours.Ticket.Domain.ValueObjects.TicketId;
import com.webdev.productsystem.Tours.Tour.Domain.Tour;
import com.webdev.productsystem.Tours.Tour.Domain.Ports.TourRepository;
import com.webdev.productsystem.Tours.Tour.Domain.ValueObjects.TourId;
import com.webdev.productsystem.Tours.Ticket.Domain.Ports.TicketRepository;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class HibernateTourRepository extends HibernateRepository<Tour> implements TourRepository {

    public HibernateTourRepository(SessionFactory sessionFactory, Class<Tour> aggregateClass) {
        super(sessionFactory, aggregateClass);
    }

    @Override
    public void save(Tour ticket) {

    }

    @Override
    public void update(Tour ticket) {

    }

    @Override
    public void delete(Tour ticket) {

    }

    @Override
    public Optional<List<Tour>> all() {
        return getAll();
    }

    @Override
    public Optional<Tour> find(TourId id) {
        return Optional.empty();
    }
}
