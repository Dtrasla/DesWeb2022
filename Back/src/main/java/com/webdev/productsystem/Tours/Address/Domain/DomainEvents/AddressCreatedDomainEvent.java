package com.webdev.productsystem.Tours.Address.Domain.DomainEvents;

import com.webdev.productsystem.Shared.Domain.Bus.Event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public class AddressCreatedDomainEvent extends DomainEvent {
    private String id;
    private String data;
    private String zipCode;
    private String blockId;
    private String cityId;

    public AddressCreatedDomainEvent() {
        super(null);
    }

    public AddressCreatedDomainEvent(String aggregateId, String data, String zipCode, String blockId, String cityId) {
        super(aggregateId);
        this.data = data;
        this.zipCode = zipCode;
        this.blockId = blockId;
        this.cityId = cityId;
    }

    public AddressCreatedDomainEvent(String aggregateId, String eventId, String occurredOn, String id, String data, String zipCode, String blockId, String cityId) {
        super(aggregateId, eventId, occurredOn);
        this.id = id;
        this.data = data;
        this.zipCode = zipCode;
        this.blockId = blockId;
        this.cityId = cityId;
    }

    public String getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getBlockId() {
        return blockId;
    }

    public String getCityId() {
        return cityId;
    }

    @Override
    public String eventName() {
        return "add.address";
    }

    @Override
    public HashMap<String, Serializable> toPrimitive() {
        return new HashMap<String, Serializable>(){{
            put("id", id);
            put("data", data);
            put("zipCode", zipCode);
            put("blockId", blockId);
            put("cityId", cityId);
        }};
    }

    @Override
    public DomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new AddressCreatedDomainEvent(aggregateId, eventId, occurredOn, (String)body.get("id"), (String)body.get("data"),
                (String)body.get("zipCode"), (String)body.get("blockId"), (String)body.get("cityId"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressCreatedDomainEvent that = (AddressCreatedDomainEvent) o;
        return Objects.equals(id, that.id) && Objects.equals(data, that.data) && Objects.equals(zipCode, that.zipCode) && Objects.equals(blockId, that.blockId) && Objects.equals(cityId, that.cityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, data, zipCode, blockId, cityId);
    }
}
