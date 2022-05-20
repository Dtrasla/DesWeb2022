package com.webdev.productsystem.Tours.Booking.Infrastructure.Controllers;
import com.webdev.productsystem.Tours.Booking.Application.Find.FindBookingById;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
<<<<<<< HEAD:src/main/java/com/webdev/productsystem/Tours/Booking/infrastructure/Controllers/BookingFindById.java
@RequestMapping(value = "/Booking")
@Tag(name= "Booking", description = "Booking REST API")
=======
@RequestMapping(value = "/booking")
>>>>>>> develop:src/main/java/com/webdev/productsystem/Tours/Booking/Infrastructure/Controllers/BookingFindById.java
public class BookingFindById {

    @Autowired
    private FindBookingById finder;

    @Operation( summary = "Find a Booking", description = "Find a Booking from the system", tags = {"Booking"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description= "Booking Found"),

    })
    @GetMapping("/{tourId}")
    public ResponseEntity<HashMap<String, Object>> execute(@PathVariable(value = "cityId") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(finder.execute(id).data());
    }

}

