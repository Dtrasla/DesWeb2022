package com.webdev.productsystem.Tours.Address.Domain;


import com.webdev.productsystem.Tours.Address.Domain.ValueObjects.AddressData;
import com.webdev.productsystem.Tours.Address.Domain.ValueObjects.AddressId;
import com.webdev.productsystem.Tours.Address.Domain.ValueObjects.AddressZipCode;

public class Address {
    public AddressId addressId;
    public AddressData addressData;
    public AddressZipCode addressZipCode;

    public Address(AddressId addressId, AddressData addressData, AddressZipCode addressZipCode) {
        this.addressId = addressId;
        this.addressData = addressData;
        this.addressZipCode = addressZipCode;
    }

    public static Address create(AddressId addressId, AddressData addressData, AddressZipCode addressZipCode) {
        Address address = new Address(addressId, addressData, addressZipCode);
        return address;
    }
}
