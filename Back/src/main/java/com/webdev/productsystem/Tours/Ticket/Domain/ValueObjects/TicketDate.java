package com.webdev.productsystem.Tours.Ticket.Domain.ValueObjects;

import com.webdev.productsystem.Shared.Domain.Aggregate.StringValueObject;
import com.webdev.productsystem.Tours.Ticket.Domain.Exceptions.InvalidDate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class TicketDate extends StringValueObject {

    public TicketDate(){}
    public TicketDate(String date){
        validate(date);
        this.value = date;
    }

    private void validate(String date) {
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime test = LocalDateTime.parse(date,dtf);
            if(test.isBefore(now)){
                throw new InvalidDate("No se puede crear un tiquete antes de la fecha actual \nFecha de hoy: "+dtf.format(now)+" Fecha ingresada "+dtf.format(test));
            }
        }catch (DateTimeParseException e){
            throw new InvalidDate("El formato de la fecha es invalido");
        }




    }


}
