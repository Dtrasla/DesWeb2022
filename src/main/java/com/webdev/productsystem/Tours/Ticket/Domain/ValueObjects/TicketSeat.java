package com.webdev.productsystem.Tours.Ticket.Domain.ValueObjects;

import com.webdev.productsystem.Shared.Domain.Aggregate.IntegerValueObject;
import com.webdev.productsystem.Tours.Ticket.Domain.Exceptions.InvalidSeat;

public class TicketSeat extends IntegerValueObject {
    public int capacidadAvion=300;

    private TicketSeat(){}

    public TicketSeat(int seat){
        validate(seat);
        this.value=seat;
    }

    public void validate(int seat){

        if(seat<0 || seat>capacidadAvion){
            throw new InvalidSeat("Asiento invalido, no puede ser un asiento menor o igual a cero. Tampoco puede exceder la" +"capacidad del avion");
        }

    }
}
