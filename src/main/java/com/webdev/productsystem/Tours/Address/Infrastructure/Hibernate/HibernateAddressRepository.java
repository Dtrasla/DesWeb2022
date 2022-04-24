package com.webdev.productsystem.Tours.Address.Infrastructure.Hibernate;

import com.webdev.productsystem.Shared.Infrastruture.Hibernate.HibernateRepository;
import com.webdev.productsystem.Tours.Address.Domain.Address;
import com.webdev.productsystem.Tours.Address.Domain.Ports.AddressRepository;
import com.webdev.productsystem.Tours.Address.Domain.ValueObjects.AddressId;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class HibernateAddressRepository extends HibernateRepository<Address> implements AddressRepository {


    public HibernateAddressRepository(SessionFactory sessionFactory, Class<Address> aggregateClass) {
        super(sessionFactory, aggregateClass);
    }

    @Override
    public void save(Address address) {
        persist(address);

    }

    @Override
    public void update(Address address) {

        super.updateEntity(address);

    }

    @Override
    public void delete(Address address) {
        super.deleteEntity(address);

    }

    @Override
    public Optional<Address> find(AddressId id) {

        return super.byId(id);
    }

    @Override
    public Optional<List<Address>> all() {
        return super.getAll();

    }
}
