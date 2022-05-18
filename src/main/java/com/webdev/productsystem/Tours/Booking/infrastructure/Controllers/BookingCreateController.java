package com.webdev.productsystem.Tours.Booking.infrastructure.Controllers;
import com.webdev.productsystem.Tours.Booking.Application.Create.CreateBooking;
import com.webdev.productsystem.Tours.Booking.Domain.Exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/Booking")
public class BookingCreateController {
    @Autowired
    private CreateBooking creator;

    @PostMapping(value = "/create")
    public ResponseEntity execute(@RequestBody BookingCreatorRequest request) {
        creator.execute(request.getId(), request.getTicket(), request.getHotelsId(),request.getTourId());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }


    @ExceptionHandler(BookingAlreadyExists.class)
    @ResponseStatus(code = HttpStatus.CONFLICT)
    public ResponseEntity<HashMap> handleBookingAlreadyExists(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new HashMap<>() {{
            put("error", e.getMessage());
        }});
    }

    @ExceptionHandler(BookingNotFound.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ResponseEntity<HashMap> handleBookingNotFound(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new HashMap<>() {{
            put("error", e.getMessage());
        }});
    }

    static class BookingCreatorRequest {

        private String id;
        private String tourId;
        private List<String> hotelsId;
        private String ticket;
     
        public String getId() {
            return id;
        }

        public String getTourId() {
            return tourId;
        }
        
        public List<String> getHotelsId() {
            return hotelsId;
        }

        public String getTicket() {
            return ticket;
        }

        
    }
}
