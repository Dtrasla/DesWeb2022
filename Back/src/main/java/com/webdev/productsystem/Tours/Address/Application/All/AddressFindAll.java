package com.webdev.productsystem.Tours.Address.Application.All;

import com.webdev.productsystem.Tours.Address.Domain.Address;
import com.webdev.productsystem.Tours.Address.Domain.Ports.AddressRepository;

import java.util.ArrayList;
import java.util.List;

public class AddressFindAll {
    private AddressRepository repository;

    public AddressFindAll(AddressRepository repository) {
        this.repository = repository;
    }

    public List<Address> execute() {
        List<Address> result = new ArrayList<Address>();
        if (repository.all().isPresent())
            result = repository.all().get();
        return result;
    }
}
