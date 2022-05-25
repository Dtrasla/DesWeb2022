package com.webdev.productsystem.Tours.TouristicLocation.Infrastructure.Adapters;


import com.webdev.productsystem.Shared.Infrastruture.Hibernate.HibernateRepository;
import com.webdev.productsystem.Tours.TouristicLocation.Domain.Ports.TouristicLocationRepository;
import com.webdev.productsystem.Tours.TouristicLocation.Domain.TouristicLocation;
import com.webdev.productsystem.Tours.TouristicLocation.Domain.ValueObjects.TouristicLocationId;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Transactional("transactional-manager")
public class HibernateTouristicLocationRepository extends HibernateRepository<TouristicLocation> implements TouristicLocationRepository {
    public HibernateTouristicLocationRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        super(sessionFactory, TouristicLocation.class);
    }

    @Override
    public void save(TouristicLocation touristicLocation) {
        persist(touristicLocation);
    }

    @Override
    public void update(TouristicLocation touristicLocation) {
        updateEntity(touristicLocation);
    }

    @Override
    public void delete(TouristicLocation touristicLocation) {
        deleteEntity(touristicLocation);
    }

    @Override
    public Optional<TouristicLocation> findById(TouristicLocationId id) {
        return byId(id);
    }

    @Override
    public Optional<List<TouristicLocation>> all() {
        return getAll();
    }
}
