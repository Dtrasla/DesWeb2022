package com.webdev.productsystem.Tours.Booking.infrastructure.Controllers;
import com.webdev.productsystem.Tours.Hotel.Application.Delete.HotelRemover;
import com.webdev.productsystem.Tours.Booking.Application.Delete.DeleteBooking;
import com.webdev.productsystem.Tours.Booking.Domain.Exceptions.BookingNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/Booking")
public class BookingDeleteController {
    @Autowired
    private DeleteBooking remover;

    @DeleteMapping(value = "/delete/{BookingId}")
    public ResponseEntity execute(@PathVariable(value = "BookingId") String id) {
        remover.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
    
    @ExceptionHandler(BookingNotFound.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ResponseEntity<HashMap> handleBookingNotFound(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new HashMap<>() {{
            put("error", e.getMessage());
        }});
    }
}
