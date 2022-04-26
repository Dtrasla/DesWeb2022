package com.webdev.productsystem.Tours.Address.Application.Create;

import com.webdev.productsystem.Tours.Address.Domain.Address;
import com.webdev.productsystem.Tours.Address.Domain.Excpetions.AddressAlreadyExists;
import com.webdev.productsystem.Tours.Address.Domain.Ports.AddressRepository;
import com.webdev.productsystem.Tours.Address.Domain.ValueObjects.AddressData;
import com.webdev.productsystem.Tours.Address.Domain.ValueObjects.AddressId;
import com.webdev.productsystem.Tours.Address.Domain.ValueObjects.AddressZipCode;
import com.webdev.productsystem.Tours.Address.Domain.ValueObjects.CityId;

public class AddressCreator {
    private AddressRepository repository;

    public AddressCreator(AddressRepository repository) {
        this.repository = repository;
    }

    public void execute(String id, String data, String zipcode, String cityId) {
        validate(id);
        this.repository.save(Address.create(new AddressId(id), new AddressData(data), new AddressZipCode(zipcode), new CityId(cityId)));
    }

    private void validate(String id) {
        checkIfAlreadyExists(id);
    }

    private void checkIfAlreadyExists(String id) {
        if (repository.findById(new AddressId(id)).isPresent())
            throw new AddressAlreadyExists("A address with that Id already exists");
    }
}
