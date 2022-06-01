package com.webdev.productsystem.Tours.Address.Domain.Ports;

import com.webdev.productsystem.Tours.Address.Domain.Address;
import com.webdev.productsystem.Tours.Address.Domain.ValueObjects.AddressId;

import java.util.List;
import java.util.Optional;

public interface AddressRepository {
    void save(Address address);
    void update(Address address);
    void delete(Address address);
    Optional<Address> findById(AddressId id);
    Optional<List<Address>> all();
}
