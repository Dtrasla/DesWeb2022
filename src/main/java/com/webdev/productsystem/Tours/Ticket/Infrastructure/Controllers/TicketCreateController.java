package com.webdev.productsystem.Tours.Ticket.Infrastructure.Controllers;

import com.webdev.productsystem.Tours.Ticket.Application.Create.CreateTicket;
import com.webdev.productsystem.Tours.Ticket.Domain.Exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/ticket")
public class TicketCreateController {
    @Autowired
    private CreateTicket creator;

    @PostMapping(value = "/create")
    public ResponseEntity execute(@RequestBody TicketCreatorRequest request) {
        creator.execute(request.getId(), request.getDate(), request.getGate(), request.getSeat(), request.getOriginCity(), request.getDestinationCity(), request.getUserId());
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

        private String id;
        private String date;
        private int seat ;
        private int gate;
        private String originCity;
        private String destinationCity;
        private String userId;


        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
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

        public String getOriginCity() {
            return originCity;
        }

        public void setOriginCity(String originCity) {
            this.originCity = originCity;
        }

        public String getDestinationCity() {
            return destinationCity;
        }

        public void setDestinationCity(String destinationCity) {
            this.destinationCity = destinationCity;
        }
    }
}
