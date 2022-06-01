package com.webdev.productsystem.Tours.Address.Application.Create;

import com.webdev.productsystem.Shared.Domain.Bus.Event.EventBus;
import com.webdev.productsystem.Tours.Address.Domain.Address;
import com.webdev.productsystem.Tours.Address.Domain.Excpetions.AddressAlreadyExists;
import com.webdev.productsystem.Tours.Address.Domain.Ports.AddressRepository;
import com.webdev.productsystem.Tours.Address.Domain.ValueObjects.*;

public class AddressCreator {
    private final AddressRepository repository;
    private final EventBus eventBus;

    public AddressCreator(AddressRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus = eventBus;
    }

    public void execute(String id, String data, String zipcode, String blockId, String cityId) {
        validate(id);
        Address address = Address.create(new AddressId(id), new AddressData(data), new AddressZipCode(zipcode), new BlockId(blockId),new CityId(cityId));
        this.repository.save(address);
        this.eventBus.publish(address.pullDomainEvents());
    }

    private void validate(String id) {
        checkIfAlreadyExists(id);
    }

    private void checkIfAlreadyExists(String id) {
        if (repository.findById(new AddressId(id)).isPresent())
            throw new AddressAlreadyExists("A address with that Id already exists");
    }
}
