package com.webdev.productsystem.Tours.Address.Infrastructure.Adapters;

import com.webdev.productsystem.Shared.Infrastruture.Hibernate.HibernateRepository;
import com.webdev.productsystem.Tours.Address.Domain.Address;
import com.webdev.productsystem.Tours.Address.Domain.Ports.AddressRepository;
import com.webdev.productsystem.Tours.Address.Domain.ValueObjects.AddressId;
import org.hibernate.SessionFactory;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public class HibernateAddressRepository extends HibernateRepository<Address> implements AddressRepository {
    public HibernateAddressRepository(SessionFactory sessionFactory) {
        super(sessionFactory, Address.class);
    }

    @Override
    public void save(Address address) {
        persist(address);
    }

    @Override
    public void update(Address address) { updateEntity(address); }

    @Override
    public void delete(Address address) { deleteEntity(address); }

    @Override
    public Optional<Address> findById(AddressId id) { return byId(id); }

    @Override
    public Optional<List<Address>> all() { return getAll(); }
}
