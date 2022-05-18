package com.webdev.productsystem.Tours.Address.Application.Update;

import com.webdev.productsystem.Tours.Address.Domain.Address;
import com.webdev.productsystem.Tours.Address.Domain.Excpetions.AddressNotExists;
import com.webdev.productsystem.Tours.Address.Domain.Ports.AddressRepository;
import com.webdev.productsystem.Tours.Address.Domain.ValueObjects.AddressData;
import com.webdev.productsystem.Tours.Address.Domain.ValueObjects.AddressId;

public class AddressDataUpdater {
    private AddressRepository repository;

    public AddressDataUpdater(AddressRepository repository) {
        this.repository = repository;
    }

    public void execute(String id, String data) {
        validate(id);
        Address address = repository.findById(new AddressId(id)).get();
        address.updateData(new AddressData(data));
        repository.update(address);
    }

    private void validate(String id) {
        checkIfExists(id);
    }

    private void checkIfExists(String id) {
        if(!repository.findById(new AddressId(id)).isPresent())
            throw new AddressNotExists("A address with that Id doesn't exist");
    }
}
