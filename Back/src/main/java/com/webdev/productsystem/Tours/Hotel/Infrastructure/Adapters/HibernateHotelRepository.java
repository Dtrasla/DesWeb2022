package com.webdev.productsystem.Tours.Hotel.Infrastructure.Adapters;

import com.webdev.productsystem.Shared.Infrastruture.Hibernate.HibernateRepository;
import com.webdev.productsystem.Tours.Hotel.Domain.Hotel;
import com.webdev.productsystem.Tours.Hotel.Domain.Ports.HotelRepository;
import com.webdev.productsystem.Tours.Hotel.Domain.ValueObjects.HotelId;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public class HibernateHotelRepository extends HibernateRepository<Hotel> implements HotelRepository {

    public HibernateHotelRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        super(sessionFactory, Hotel.class);
    }

    @Override
    public void save(Hotel hotel) {
        persist(hotel);
    }

    @Override
    public void update(Hotel hotel) {
        updateEntity(hotel);
    }

    @Override
    public void delete(Hotel hotel) {
        deleteEntity(hotel);
    }

    @Override
    public Optional<Hotel> findById(HotelId id) {
        return byId(id);
    }

    @Override
    public Optional<List<Hotel>> all() {
        return getAll();
    }
}
