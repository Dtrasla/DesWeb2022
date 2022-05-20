<<<<<<< HEAD:src/main/java/com/webdev/productsystem/Tours/Booking/infrastructure/Controllers/BookingDeleteController.java
package com.webdev.productsystem.Tours.Booking.infrastructure.Controllers;
import com.webdev.productsystem.Shared.Infrastruture.Schema.BookingErrorSchema;
import com.webdev.productsystem.Tours.Hotel.Application.Delete.HotelRemover;
=======
package com.webdev.productsystem.Tours.Booking.Infrastructure.Controllers;
>>>>>>> develop:src/main/java/com/webdev/productsystem/Tours/Booking/Infrastructure/Controllers/BookingDeleteController.java
import com.webdev.productsystem.Tours.Booking.Application.Delete.DeleteBooking;
import com.webdev.productsystem.Tours.Booking.Domain.Exceptions.BookingNotFound;
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
<<<<<<< HEAD:src/main/java/com/webdev/productsystem/Tours/Booking/infrastructure/Controllers/BookingDeleteController.java
@RequestMapping(value = "/Booking")
@Tag(name= "Booking", description = "Booking REST API")
=======
@RequestMapping(value = "/booking")
>>>>>>> develop:src/main/java/com/webdev/productsystem/Tours/Booking/Infrastructure/Controllers/BookingDeleteController.java
public class BookingDeleteController {
    @Autowired
    private DeleteBooking remover;


    @Operation( summary = "Delete a Booking", description = "Delete a Booking from the system", tags = {"Booking"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description= "Booking Deleted"),
            @ApiResponse(responseCode = "404", description= "Booking Not Found"),


    })
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
