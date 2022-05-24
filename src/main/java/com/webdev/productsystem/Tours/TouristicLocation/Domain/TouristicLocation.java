package com.webdev.productsystem.Tours.TouristicLocation.Domain;

import com.webdev.productsystem.Tours.Hotel.Domain.Hotel;
import com.webdev.productsystem.Tours.Hotel.Domain.ValueObjects.HotelId;
import com.webdev.productsystem.Tours.Hotel.Domain.ValueObjects.HotelName;
import com.webdev.productsystem.Tours.TouristicLocation.Domain.Entities.TouristicLocationAddress;
import com.webdev.productsystem.Tours.TouristicLocation.Domain.ValueObjects.TouristicLocationId;
import com.webdev.productsystem.Tours.TouristicLocation.Domain.ValueObjects.TouristicLocationName;


import java.util.HashMap;
import java.util.Optional;

public class TouristicLocation {
    private TouristicLocationId id;
    private TouristicLocationName name;
    private Optional<TouristicLocationAddress> address;

    public TouristicLocation(TouristicLocationId id, TouristicLocationName name,  Optional<TouristicLocationAddress> address) {
        this.id = id;
        this.name = name;
        this.address = address;

    }
    public void addAddress(TouristicLocationAddress address) {
        this.address = Optional.ofNullable(address);
    }

    public void updateName(TouristicLocationName name) {
        this.name = name;
    }

    private HashMap<String, Object> createAddress() {
        return address.get().data();
    }

    public static TouristicLocation create(TouristicLocationId id, TouristicLocationName name) {
        return new TouristicLocation(id, name, Optional.empty());
    }

    public HashMap<String, Object> data() {
        return new HashMap<>() {{
            put("touristicLocationId", id.value());
            put("touristicLocationName", name.value());
        }};
    }
}
