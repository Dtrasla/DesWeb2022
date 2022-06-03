package com.webdev.productsystem.Tours.Booking.infrastructure.Controllers;
import com.webdev.productsystem.Tours.Booking.Application.Find.FindBookingById;
import io.swagger.v3.oas.annotations.Operation;
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
@Tag(name= "Booking", description = "Booking REST API")
public class BookingFindById {
    @Autowired
    private FindBookingById finder;

    @Operation( summary = "Find a Booking", description = "Find a Booking from the system", tags = {"Booking"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description= "Booking Found"),

    })
    @GetMapping("/{tourId}")
    @CrossOrigin("*")
    public ResponseEntity<HashMap<String, Object>> execute(@PathVariable(value = "cityId") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(finder.execute(id).data());
    }

}

