package com.webdev.productsystem.Tours.Address.Application.Create;

import com.webdev.productsystem.Tours.Address.Domain.Address;
import com.webdev.productsystem.Tours.Address.Domain.Ports.AddressRepository;
import com.webdev.productsystem.Tours.Address.Domain.ValueObjects.AddressData;
import com.webdev.productsystem.Tours.Address.Domain.ValueObjects.AddressId;
import com.webdev.productsystem.Tours.Address.Domain.ValueObjects.AddressZipCode;

public class CreateAddress {

    private final AddressRepository repository;

    public CreateAddress(AddressRepository repository) {
        this.repository = repository;
    }

    public void execute(String id, String data, String zipcode){

        this.repository.save(Address.create(new AddressId(id), new AddressData(data), new AddressZipCode(zipcode),null));

    }



}
