package com.webdev.productsystem.Tours.Ticket.Infrastructure.Controllers;

import com.webdev.productsystem.Tours.Hotel.Application.Delete.HotelRemover;
import com.webdev.productsystem.Tours.Ticket.Application.Delete.DeleteTicket;
import com.webdev.productsystem.Tours.Ticket.Domain.Exceptions.TicketNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/ticket")
public class TicketDeleteController {
    @Autowired
    private DeleteTicket remover;

    @DeleteMapping(value = "/delete/{ticketId}")
    public ResponseEntity execute(@PathVariable(value = "ticketId") String id) {
        remover.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @ExceptionHandler(TicketNotFound.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ResponseEntity<HashMap> handleTicketNotFound(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new HashMap<>() {{
            put("error", e.getMessage());
        }});
    }
}
