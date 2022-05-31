package com.webdev.productsystem.Users.Phone.Domain.DomainEvents;

import com.webdev.productsystem.Shared.Domain.Bus.Event.DomainEvent;
import com.webdev.productsystem.Users.Phone.Domain.Phone;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public class PhoneCreatedDomainEvent extends DomainEvent {

    private String id;
    private String countryCode;
    private String number;

    public PhoneCreatedDomainEvent() {
        super(null);
    }

    public PhoneCreatedDomainEvent(String aggregateId, String id, String countryCode, String number) {
        super(aggregateId);
        this.id = id;
        this.countryCode = countryCode;
        this.number = number;
    }

    public PhoneCreatedDomainEvent(String aggregateId, String eventId, String occurredOn, String id, String countryCode, String number) {
        super(aggregateId, eventId, occurredOn);
        this.id = id;
        this.countryCode = countryCode;
        this.number = number;
    }

    public PhoneCreatedDomainEvent(String id, String countryCode, String number) {
        this.id = id;
        this.countryCode = countryCode;
        this.number = number;
    }


    public String getId() {
        return id;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String eventName(){
        return "add.phone";
    }

    @Override
    public HashMap<String, Serializable> toPrimitive() {
        return new HashMap<String, Serializable>(){{
            put("id",id);
            put("countryCode",countryCode);
            put("number",number);

        }};
    }

    @Override
    public DomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new PhoneCreatedDomainEvent(aggregateId, eventId, occurredOn, (String)body.get("id"), (String)body.get("countryCode"), (String)body.get("number") );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneCreatedDomainEvent that = (PhoneCreatedDomainEvent) o;
        return Objects.equals(id, that.id) && Objects.equals(countryCode, that.countryCode) && Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, countryCode, number);
    }
}
