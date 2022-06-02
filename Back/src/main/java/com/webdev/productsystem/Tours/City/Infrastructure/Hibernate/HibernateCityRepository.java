package com.webdev.productsystem.Tours.City.Infrastructure.Hibernate;

import com.webdev.productsystem.Shared.Infrastruture.Hibernate.HibernateRepository;
import com.webdev.productsystem.Tours.Ticket.Domain.ValueObjects.TicketId;
import com.webdev.productsystem.Tours.Tour.Domain.Tour;
import com.webdev.productsystem.Tours.Tour.Domain.Ports.TourRepository;
import com.webdev.productsystem.Tours.Tour.Domain.ValueObjects.TourId;
import com.webdev.productsystem.Tours.City.Domain.City;
import com.webdev.productsystem.Tours.City.Domain.Ports.CityRepository;
import com.webdev.productsystem.Tours.City.Domain.ValueObjects.CityId;
import com.webdev.productsystem.Tours.Ticket.Domain.Ports.TicketRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

@Transactional
public class HibernateCityRepository extends HibernateRepository<City> implements CityRepository {

    public HibernateCityRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        super(sessionFactory, City.class);
    }

    @Override
    public void save(City city) {
        
    }

    @Override
    public void update(City city) {
        
    }

    @Override
    public void delete(City city) {
        
    }

    @Override
    public Optional<City> find(CityId id) {
        return Optional.empty();
    }

    @Override
    public Optional<List<City>> all() {
        return getAll();
    }
    
}
