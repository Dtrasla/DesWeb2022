package com.webdev.productsystem.Tours.Address.Domain;


import com.webdev.productsystem.Tours.Address.Domain.ValueObjects.AddressData;
import com.webdev.productsystem.Tours.Address.Domain.ValueObjects.AddressId;
import com.webdev.productsystem.Tours.Address.Domain.ValueObjects.AddressZipCode;
import com.webdev.productsystem.Tours.Address.Domain.ValueObjects.CityId;

import java.util.HashMap;

public class Address {
    private AddressId id;
    private AddressData data;
    private AddressZipCode zipCode;
    private CityId cityId;

    public Address() {
    }

    public Address(AddressId id, AddressData data, AddressZipCode zipCode, CityId cityId) {
        this.id = id;
        this.data = data;
        this.zipCode = zipCode;
        this.cityId = cityId;
    }

    public static Address create(AddressId id, AddressData data, AddressZipCode zipCode, CityId cityId) {
        return new Address(id, data, zipCode, cityId);
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
            put("city", cityId.value());
        }};
    }
}
