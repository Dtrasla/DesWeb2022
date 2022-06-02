package com.webdev.productsystem.Tours.TouristicLocation.Domain.DomainEvents;

import com.webdev.productsystem.Shared.Domain.Bus.Event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public class TouristicLocationCreatedDomainEvent extends DomainEvent {
    private String id;
    private String name;
    private String tourId;

    public TouristicLocationCreatedDomainEvent() {
        super(null);
    }

    public TouristicLocationCreatedDomainEvent(String aggregateId, String name, String tourId) {
        super(aggregateId);
        this.name = name;
        this.tourId = tourId;
    }

    public TouristicLocationCreatedDomainEvent(String aggregateId, String eventId, String occurredOn, String id, String name, String tourId) {
        super(aggregateId, eventId, occurredOn);
        this.id = id;
        this.name = name;
        this.tourId = tourId;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTourId() {
        return tourId;
    }

    @Override
    public String eventName() {
        return "add.touristicLocation";
    }

    @Override
    public HashMap<String, Serializable> toPrimitive() {
        return new HashMap<String, Serializable>() {{
            put("id", id);
            put("name", name);
            put("tourId", tourId);
        }};
    }

    @Override
    public DomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new TouristicLocationCreatedDomainEvent(aggregateId, eventId, occurredOn, (String) body.get("id"), (String) body.get("name"), (String) body.get("tourId"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TouristicLocationCreatedDomainEvent that = (TouristicLocationCreatedDomainEvent) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(tourId, that.tourId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, tourId);
    }
}
