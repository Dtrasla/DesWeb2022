package com.webdev.productsystem.Tours.Ticket.Infrastructure.Controllers;

import com.webdev.productsystem.Shared.Infrastruture.Schema.TicketErrorSchema;
import com.webdev.productsystem.Tours.Ticket.Application.Create.CreateTicket;
import com.webdev.productsystem.Tours.Ticket.Domain.Exceptions.*;
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
public class TicketCreateController {
    @Autowired
    private CreateTicket creator;

    @Operation(summary = "Create a new Ticket", description = " Create a New Ticket in the System", tags ={"Ticket"})

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description= "Ticket created"),
            @ApiResponse(responseCode = "400", description= "Invalid Ticket input", content= @Content(schema = @Schema(implementation = TicketErrorSchema.class))),
            @ApiResponse(responseCode = "409", description= "Ticket already exists", content= @Content(schema = @Schema(implementation = TicketErrorSchema.class))),
            @ApiResponse(responseCode = "404", description= "Ticket not found"),

    })
    @PostMapping(value = "/create")
    @CrossOrigin("*")
    public ResponseEntity execute(@RequestBody TicketCreatorRequest request) {
        creator.execute(request.getId(), request.getDate(), request.getGate(), request.getSeat(), request.getOriginCityId(), request.getDestinationCityId(), request.getUserId());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @ExceptionHandler(InvalidDate.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<HashMap> handleBadRequest(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new HashMap<>() {{
            put("error", e.getMessage());
        }});
    }

    @ExceptionHandler(InvalidGate.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<HashMap> handleInvalidGate(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new HashMap<>() {{
            put("error", e.getMessage());
        }});
    }

    @ExceptionHandler(InvalidSeat.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<HashMap> handleInvalidSeat(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new HashMap<>() {{
            put("error", e.getMessage());
        }});
    }

    @ExceptionHandler(TicketAlreadyExists.class)
    @ResponseStatus(code = HttpStatus.CONFLICT)
    public ResponseEntity<HashMap> handleTicketAlreadyExists(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new HashMap<>() {{
            put("error", e.getMessage());
        }});
    }

    @ExceptionHandler(TicketNotFound.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ResponseEntity<HashMap> handleTicketNotFound(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new HashMap<>() {{
            put("error", e.getMessage());
        }});
    }

    static class TicketCreatorRequest {

        @Schema (description = "Ticket ID", example= "92d110b4-8217-4122-b657-29527f1df338")
        private String id;

        @Schema (description = "Ticket Date, in format dd/MM/yyyy HH:mm", example= "21/03/2000 21:30")
        private String date;

        @Schema (description = "Ticket seat, the number must be higher than 0 and less than plane seat capacity", example= "21A")
        private int seat ;

        @Schema (description = "Ticket gate, must be a numer and the gate must exist", example= "9")
        private int gate;

        @Schema (description = "Ticket origin city", example= "Bogotá D.C")
        private String originCityId;

        @Schema (description = "Ticket destination city", example= "París")
        private String destinationCityId;

        @Schema (description = "User id", example= "6705a4cc-5e59-4f29-8cc5-9ec6e7434d0d")
        private String userId;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public int getSeat() {
            return seat;
        }

        public void setSeat(int seat) {
            this.seat = seat;
        }

        public int getGate() {
            return gate;
        }

        public void setGate(int gate) {
            this.gate = gate;
        }

        public String getOriginCityId() {
            return originCityId;
        }

        public void setOriginCityId(String originCityId) {
            this.originCityId = originCityId;
        }

        public String getDestinationCityId() {
            return destinationCityId;
        }

        public void setDestinationCityId(String destinationCityId) {
            this.destinationCityId = destinationCityId;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
    }
}
