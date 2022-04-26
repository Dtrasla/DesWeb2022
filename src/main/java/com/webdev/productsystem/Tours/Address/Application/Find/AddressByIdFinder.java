package com.webdev.productsystem.Tours.Address.Application.Find;

import com.webdev.productsystem.Tours.Address.Domain.Address;
import com.webdev.productsystem.Tours.Address.Domain.Excpetions.AddressNotExists;
import com.webdev.productsystem.Tours.Address.Domain.Ports.AddressRepository;
import com.webdev.productsystem.Tours.Address.Domain.ValueObjects.AddressId;
import com.webdev.productsystem.Tours.Hotel.Domain.Exceptions.HotelNotExists;

public class AddressByIdFinder {
    private AddressRepository repository;

    public AddressByIdFinder(AddressRepository repository) { this.repository = repository; }

    public Address execute(String id) {
        validate(id);
        return repository.findById(new AddressId(id)).get();
    }

    private void validate(String id) {
        checkIfExists(id);
    }

    private void checkIfExists(String id) {
        if(!repository.findById(new AddressId(id)).isPresent())
            throw new AddressNotExists("A address with that Id doesn't exist");
    }
}
