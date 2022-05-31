package com.webdev.productsystem.Users.Phone.Domain.DomainEvents;

import com.webdev.productsystem.Shared.Domain.Bus.Event.DomainEvent;
import com.webdev.productsystem.Users.Phone.Domain.Phone;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public class PhoneCreatedDomainEvent extends DomainEvent {

    private Integer id;
    private Integer countryCode;
    private Integer number;

    public PhoneCreatedDomainEvent() {
        super(null);
    }

    public PhoneCreatedDomainEvent(String aggregateId, Integer id, Integer countryCode, Integer number) {
        super(aggregateId);
        this.id = id;
        this.countryCode = countryCode;
        this.number = number;
    }

    public PhoneCreatedDomainEvent(String aggregateId, String eventId, String occurredOn, Integer id, Integer countryCode, Integer number) {
        super(aggregateId, eventId, occurredOn);
        this.id = id;
        this.countryCode = countryCode;
        this.number = number;
    }

    public PhoneCreatedDomainEvent(Integer id, Integer countryCode, Integer number) {
        this.id = id;
        this.countryCode = countryCode;
        this.number = number;
    }


    public Integer getId() {
        return id;
    }

    public Integer getCountryCode() {
        return countryCode;
    }

    public Integer getNumber() {
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
        return new PhoneCreatedDomainEvent(aggregateId, eventId, occurredOn, (Integer)body.get("id"), (Integer)body.get("countryCode"), (Integer)body.get("number") );
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
