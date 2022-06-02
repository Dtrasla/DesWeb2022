package com.webdev.productsystem.Tours.Ticket.Domain.ValueObjects;

import com.webdev.productsystem.Shared.Domain.Aggregate.CustomUUID;
import com.webdev.productsystem.Shared.Domain.Aggregate.IntegerValueObject;

public class TicketId extends CustomUUID {
    private TicketId(){}

    public TicketId(String TicketId) {
        super(TicketId);
    }


}
