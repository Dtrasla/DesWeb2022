package com.webdev.productsystem.Tours.Address.Application.Delete;

import com.webdev.productsystem.Tours.Address.Domain.Excpetions.AddressNotExists;
import com.webdev.productsystem.Tours.Address.Domain.Ports.AddressRepository;
import com.webdev.productsystem.Tours.Address.Domain.ValueObjects.AddressId;

public class AddressRemover {
    private AddressRepository repository;

    public AddressRemover(AddressRepository repository) {
        this.repository = repository;
    }

    public void execute(String id) {
        validate(id);
        repository.delete(repository.findById(new AddressId(id)).get());
    }

    private void validate(String id) {
        checkIfExists(id);
    }

    private void checkIfExists(String id) {
        if(!repository.findById(new AddressId(id)).isPresent())
            throw new AddressNotExists("A address with that Id doesn't exist");
    }
}
