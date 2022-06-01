package com.webdev.productsystem.Tours.Address.Domain;


import com.webdev.productsystem.Shared.Domain.Aggregate.AggregateRoot;
import com.webdev.productsystem.Tours.Address.Domain.DomainEvents.AddressCreatedDomainEvent;
import com.webdev.productsystem.Tours.Address.Domain.ValueObjects.*;

import java.util.HashMap;

public class Address extends AggregateRoot {
    private AddressId id;
    private AddressData data;
    private AddressZipCode zipCode;
    private BlockId blockId;
    private CityId cityId;

    public Address() {
    }

    public Address(AddressId id, AddressData data, AddressZipCode zipCode, BlockId blockId, CityId cityId) {
        this.id = id;
        this.data = data;
        this.zipCode = zipCode;
        this.blockId = blockId;
        this.cityId = cityId;
    }

    public static Address create(AddressId id, AddressData data, AddressZipCode zipCode, BlockId blockId, CityId cityId) {
        Address address =  new Address(id, data, zipCode, blockId, cityId);
        address.record(new AddressCreatedDomainEvent(id.value(), data.value(), zipCode.value(), blockId.value(),cityId.value()));
        return address;
    }

    public void updateData(AddressData data) {
        this.data = data;
    }

    public void updateZipCode(AddressZipCode zipCode) {
        this.zipCode = zipCode;
    }

    public HashMap<String, Object> data() {
        return new HashMap<>() {{
            put("id", id.value());
            put("data", data.value());
            put("zipCode", zipCode.value());
            put("blockId", blockId.value());
            put("city", cityId.value());
        }};
    }
}
