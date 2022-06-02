package com.webdev.productsystem.Tours.Hotel.Infrastructure.Listeners;

import com.webdev.productsystem.Tours.Address.Domain.DomainEvents.AddressCreatedDomainEvent;
import com.webdev.productsystem.Tours.Hotel.Application.AddAddress.HotelAddAddress;

public final class AddAddressOnAddressCreated {
    private HotelAddAddress adder;

    public AddAddressOnAddressCreated(HotelAddAddress adder) {
        this.adder = adder;
    }

    public void on(AddressCreatedDomainEvent event){
        System.out.println("🟢 EVENT: " + event.getData());
        this.adder.execute(event.getId(), event.getCityId(), event.getData(), event.getZipCode(), event.getBlockId());
    }
}
