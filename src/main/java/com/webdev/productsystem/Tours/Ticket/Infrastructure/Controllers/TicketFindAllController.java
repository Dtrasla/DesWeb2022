package com.webdev.productsystem.Tours.Ticket.Infrastructure.Controllers;
import com.webdev.productsystem.Shared.Infrastruture.Schema.TicketErrorSchema;
import com.webdev.productsystem.Tours.Ticket.Application.Find.TicketFindAll;
import com.webdev.productsystem.Tours.Ticket.Application.Find.TicketFindAllResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/ticket")
@Tag(name = "Ticket", description = "Ticket rest API")
public class TicketFindAllController {
    @Autowired
    private TicketFindAll all;

    @Operation(summary = "Find all Tickets", description = " Find all the tickets in the system", tags ={"Ticket"})

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description= "All tickets found"),


    })

    @GetMapping(value = "/all")
    public ResponseEntity<List<HashMap<String, Object>>> execute() {
        return ResponseEntity.status(HttpStatus.OK).body(new TicketFindAllResponse(all.execute()).response());
    }

}
