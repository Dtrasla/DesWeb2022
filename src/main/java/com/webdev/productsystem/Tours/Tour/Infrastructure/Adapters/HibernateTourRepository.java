package com.webdev.productsystem.Tours.Tour.Infrastructure.Adapters;

import com.webdev.productsystem.Shared.Infrastruture.Hibernate.HibernateRepository;
import com.webdev.productsystem.Tours.Ticket.Domain.ValueObjects.TicketId;
import com.webdev.productsystem.Tours.Tour.Domain.Tour;
import com.webdev.productsystem.Tours.Tour.Domain.Ports.TourRepository;
import com.webdev.productsystem.Tours.Tour.Domain.ValueObjects.TourId;
import com.webdev.productsystem.Tours.Ticket.Domain.Ports.TicketRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

@Transactional
public class HibernateTourRepository extends HibernateRepository<Tour> implements TourRepository {

    public HibernateTourRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        super(sessionFactory, Tour.class);
    }

    @Override
    public void save(Tour tour) {
        persist(tour);
    }

    @Override
    public void update(Tour tour) {
        updateEntity(tour);
    }

    @Override
    public void delete(Tour tour) {
        deleteEntity(tour);
    }

    @Override
    public Optional<List<Tour>> all() {
        return getAll();
    }

    @Override
    public Optional<Tour> find(TourId id) {
        return byId(id);
    }
}
