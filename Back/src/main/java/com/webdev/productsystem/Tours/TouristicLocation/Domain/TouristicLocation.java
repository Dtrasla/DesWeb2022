package com.webdev.productsystem.Tours.TouristicLocation.Domain;

import com.webdev.productsystem.Shared.Domain.Aggregate.AggregateRoot;
import com.webdev.productsystem.Tours.TouristicLocation.Domain.DomainEvents.TouristicLocationCreatedDomainEvent;
import com.webdev.productsystem.Tours.TouristicLocation.Domain.Entities.TouristicLocationAddress;
import com.webdev.productsystem.Tours.TouristicLocation.Domain.ValueObjects.TourId;
import com.webdev.productsystem.Tours.TouristicLocation.Domain.ValueObjects.TouristicLocationId;
import com.webdev.productsystem.Tours.TouristicLocation.Domain.ValueObjects.TouristicLocationName;


import java.util.HashMap;
import java.util.Optional;

public class TouristicLocation extends AggregateRoot {
    private TouristicLocationId id;
    private TouristicLocationName name;
    private TourId tourId;
    private Optional<TouristicLocationAddress> address;

    public TouristicLocation(){
    }

    public TouristicLocation(TouristicLocationId id, TouristicLocationName name,  TourId tourId, Optional<TouristicLocationAddress> address) {
        this.id = id;
        this.name = name;
        this.tourId = tourId;
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

    public static TouristicLocation create(TouristicLocationId id, TouristicLocationName name, TourId tourId) {
        TouristicLocation touristicLocation =  new TouristicLocation(id, name, tourId, Optional.empty());
        touristicLocation.record(new TouristicLocationCreatedDomainEvent(id.value(), name.value(), tourId.value()));
        return touristicLocation;
    }

    public HashMap<String, Object> data() {
        return new HashMap<>() {{
            put("touristicLocationId", id.value());
            put("touristicLocationName", name.value());
            put("tourId", tourId.value());
        }};
    }
}
