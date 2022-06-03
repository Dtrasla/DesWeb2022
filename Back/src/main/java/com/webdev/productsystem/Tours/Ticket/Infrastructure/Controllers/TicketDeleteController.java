package com.webdev.productsystem.Tours.Ticket.Infrastructure.Controllers;

import com.webdev.productsystem.Shared.Infrastruture.Schema.TicketErrorSchema;
import com.webdev.productsystem.Tours.Hotel.Application.Delete.HotelRemover;
import com.webdev.productsystem.Tours.Ticket.Application.Delete.DeleteTicket;
import com.webdev.productsystem.Tours.Ticket.Domain.Exceptions.TicketNotFound;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/ticket")
@Tag(name = "Ticket", description = "Ticket rest API")
public class TicketDeleteController {
    @Autowired
    private DeleteTicket remover;

    @Operation(summary = "Delete a Ticket", description = " Delete a Ticket from the  System", tags ={"Ticket"})

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description= "Ticket deleted"),
            @ApiResponse(responseCode = "404", description= "Ticket not found"),

    })
    @DeleteMapping(value = "/delete/{ticketId}")
    @CrossOrigin("*")
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
