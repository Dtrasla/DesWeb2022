package com.webdev.productsystem.Tours.Ticket.Domain.ValueObjects;

import com.webdev.productsystem.Shared.Domain.Aggregate.CustomUUID;
import com.webdev.productsystem.Shared.Domain.Aggregate.StringValueObject;

public class DestinationCityId extends StringValueObject {
    public DestinationCityId() {}

    public DestinationCityId(String value) {
        this.value = value;
    }
}
