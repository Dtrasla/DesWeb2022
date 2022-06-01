package com.webdev.productsystem.Tours.Ticket.Application.Delete;

import com.webdev.productsystem.Tours.Ticket.Domain.Exceptions.TicketNotFound;
import com.webdev.productsystem.Tours.Ticket.Domain.Ports.TicketRepository;
import com.webdev.productsystem.Tours.Ticket.Domain.Tickets;
import com.webdev.productsystem.Tours.Ticket.Domain.ValueObjects.TicketId;

import java.util.Optional;

public class DeleteTicket {

    private TicketRepository repository;

    //Busqueda del ticket

    public DeleteTicket(TicketRepository repository){
        this.repository= repository;
    }

    public void execute(String ticketId){

        //Find the estate
        Optional<Tickets> ticketOptional = repository.find(new TicketId(ticketId));
        if(ticketOptional.isEmpty()){

            throw new TicketNotFound("No pudimos encontrar un Tiquete con el numero" + ticketId + "por favor asegurese de ingresarlo correctamente");

        }else{

            Tickets ticket = ticketOptional.get();
            repository.delete(ticket);
            System.out.print("Tiquete borrado exitosamente");

        }

    }








}
