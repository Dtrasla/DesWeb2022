package com.webdev.productsystem.Tours.Ticket.Domain.ValueObjects;

import com.webdev.productsystem.Shared.Domain.Aggregate.CustomUUID;

public class UserId extends CustomUUID {
    private UserId() {}

    public UserId(String value) {
        super(value);
    }
}
