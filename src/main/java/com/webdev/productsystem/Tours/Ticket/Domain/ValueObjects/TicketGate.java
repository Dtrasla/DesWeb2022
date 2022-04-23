package com.webdev.productsystem.Tours.Ticket.Domain.ValueObjects;

import com.webdev.productsystem.Shared.Domain.Aggregate.IntegerValueObject;
import com.webdev.productsystem.Shared.Domain.Aggregate.StringValueObject;
import com.webdev.productsystem.Tours.Ticket.Domain.Exceptions.InvalidGate;

public class TicketGate extends IntegerValueObject {

    private TicketGate(){}

    public TicketGate(int gate) {
        validate(gate) ;
        this.value = gate;
    }

    private void validate(int gate) {
        if(gate<0){

            throw new InvalidGate("La puerta de embarque es incorrecta");

        }

    }
}
