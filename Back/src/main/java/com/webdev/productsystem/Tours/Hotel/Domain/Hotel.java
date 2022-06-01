package com.webdev.productsystem.Tours.Hotel.Domain;

import com.webdev.productsystem.Shared.Domain.Aggregate.AggregateRoot;
import com.webdev.productsystem.Tours.Hotel.Domain.Entities.HotelAddress;
import com.webdev.productsystem.Tours.Hotel.Domain.ValueObjects.HotelId;
import com.webdev.productsystem.Tours.Hotel.Domain.ValueObjects.HotelName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class Hotel  extends AggregateRoot {
    private HotelId id;
    private HotelName name;
    private Optional<HotelAddress> address;

    public Hotel() {}

    public Hotel(HotelId id, HotelName name, Optional<HotelAddress> address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public static Hotel create(HotelId id, HotelName name) {
        return new Hotel(id, name, Optional.empty());
    }

    public void addAddress(HotelAddress addAddress) {
        this.address = Optional.of(addAddress);
    }

    private HashMap<String, Object> createAddress() {
        if (address.isPresent()) {
            return address.get().data();
        }
        return null;
    }

    public void updateName(HotelName name) {
        this.name = name;
    }

    public HashMap<String, Object> data() {
        return new HashMap<>() {{
            put("id", id.value());
            put("name", name.value());
            put("address", createAddress());
        }};
    }
}
