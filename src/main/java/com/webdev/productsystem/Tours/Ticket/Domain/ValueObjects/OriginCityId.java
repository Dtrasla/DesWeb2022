package com.webdev.productsystem.Tours.Ticket.Domain.ValueObjects;

import com.webdev.productsystem.Shared.Domain.Aggregate.StringValueObject;

public class OriginCityId extends StringValueObject {
    public OriginCityId() {}

    public OriginCityId(String value) {
        this.value = value;
    }
}
