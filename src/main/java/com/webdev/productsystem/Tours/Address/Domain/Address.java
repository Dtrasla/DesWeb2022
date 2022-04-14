package com.webdev.productsystem.Tours.Address.Domain;


import com.webdev.productsystem.Tours.Address.Domain.Entities.AddressCity;
import com.webdev.productsystem.Tours.Address.Domain.ValueObjects.AddressData;
import com.webdev.productsystem.Tours.Address.Domain.ValueObjects.AddressId;
import com.webdev.productsystem.Tours.Address.Domain.ValueObjects.AddressZipCode;

import java.util.HashMap;

public class Address {
    private AddressId id;
    private AddressData data;
    private AddressZipCode zipCode;
    private AddressCity city;

    public Address(AddressId id, AddressData data, AddressZipCode zipCode, AddressCity city) {
        this.id = id;
        this.data = data;
        this.zipCode = zipCode;
        this.city = city;
    }

    public static Address create(AddressId id, AddressData data, AddressZipCode zipCode, AddressCity city) {
        return new Address(id, data, zipCode, city);
    }

    private HashMap<String, Object> createCity() { return city.data(); }

    public HashMap<String, Object> data() {
        return new HashMap<>() {{
            put("id", id.value());
            put("data", data.value());
            put("zipCode", zipCode.value());
            put("city", createCity());
        }};
    }
}
