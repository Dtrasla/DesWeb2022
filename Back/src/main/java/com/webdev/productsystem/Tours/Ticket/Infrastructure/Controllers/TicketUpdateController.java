package com.webdev.productsystem.Tours.Ticket.Infrastructure.Controllers;

import com.webdev.productsystem.Tours.Ticket.Application.Update.UpdateTicketDate;
import com.webdev.productsystem.Tours.Ticket.Application.Update.UpdateTicketGate;
import com.webdev.productsystem.Tours.Ticket.Application.Update.UpdateTicketSeat;
import com.webdev.productsystem.Tours.Ticket.Domain.Exceptions.TicketNotFound;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/ticket")
@Tag(name = "Ticket", description = "Ticket rest API")
public class TicketUpdateController {

    @Autowired
    private UpdateTicketDate dateUpdater;
    @Autowired
    private UpdateTicketSeat seatUpdater;
    @Autowired
    private UpdateTicketGate gateUpdater;

    @PutMapping(value = "/")
    @CrossOrigin("*")
    public ResponseEntity execute(@RequestBody TicketUpdateRequest request){
        dateUpdater.execute(request.ticketId, request.date);
        seatUpdater.execute(request.ticketId, request.seat);
        gateUpdater.execute(request.ticketId, request.gate);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @ExceptionHandler({TicketNotFound.class})
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ResponseEntity<HashMap> handleBadRequest(RuntimeException exception) {
        HashMap<String, String> response = new HashMap<>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }


    static class TicketUpdateRequest{
        private String ticketId;
        private String date;
        private int seat;
        private int gate;

        public String getTicketId() {
            return ticketId;
        }

        public void setTicketId(String ticketId) {
            this.ticketId = ticketId;
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

        public TicketUpdateRequest() {
        }
    }






































}
