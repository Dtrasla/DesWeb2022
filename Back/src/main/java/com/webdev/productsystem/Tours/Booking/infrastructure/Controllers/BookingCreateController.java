package com.webdev.productsystem.Tours.Booking.infrastructure.Controllers;
import com.webdev.productsystem.Shared.Infrastruture.Schema.BookingErrorSchema;
import com.webdev.productsystem.Tours.Booking.Application.Create.CreateBooking;
import com.webdev.productsystem.Tours.Booking.Domain.Exceptions.*;
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
import java.util.List;

@RestController
@RequestMapping(value = "/Booking")
@Tag (name= "Booking", description = "Booking REST API")
public class BookingCreateController {
    @Autowired
    private CreateBooking creator;

    @Operation( summary = "Create a new Booking", description = "Create a new Booking in the system", tags = {"Booking"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description= "Booking created"),
            @ApiResponse(responseCode = "409", description= "Booking already Exists", content= @Content(schema = @Schema(implementation = BookingErrorSchema.class))),
            @ApiResponse(responseCode = "404", description= "Booking Not Found"),


    })

    @PostMapping(value = "/create")
    public ResponseEntity execute(@RequestBody BookingCreatorRequest request) {
        creator.execute(request.getId(), request.getHotelsId(), request.getTicket(),request.getTourId());
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

    @Schema  (description = "Booking Id", example = "bbf7ec50-d6cc-11ec-9d64-0242ac120002" )
        private String id;

        @Schema  (description = "Tour Id", example = "bbf7ed70-d6cc-11ec-9d64-0242ac120003" )
        private String tourId;

        @Schema  (description = "Hotel Id", example = " 45cd4af6-d6cd-11ec-9d64-0242ac120005" )
        private String hotelsId;

        @Schema  (description = "Ticket Id", example = "45cd4af6-d6cd-11ec-9d64-0242ac120002" )
        private String ticket;

        BookingCreatorRequest() {
        }

        public String getId() {
            return id;
        }

        public String getTourId() {
            return tourId;
        }
        
        public String getHotelsId() {
            return hotelsId;
        }

        public String getTicket() {
            return ticket;
        }

        
    }
}
