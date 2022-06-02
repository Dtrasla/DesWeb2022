package com.webdev.productsystem.Tours.Tour.Infrastructure.Controllers;

import com.webdev.productsystem.Tours.Hotel.Application.All.HotelFindAllResponse;
import com.webdev.productsystem.Tours.Tour.Application.All.TourFindAll;
import com.webdev.productsystem.Tours.Tour.Application.All.TourFindAllResponse;
import io.swagger.v3.oas.annotations.Operation;
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
@RequestMapping(value = "tour")
@Tag(name = "Tour", description = "Tour REST API")
public class TourFindAllController {
    @Autowired
    private TourFindAll all;

    @Operation(summary = "Get all the tours", description = "Find all the tours stored in the system", tags = {"Hotel"})
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Tours found") })
    @GetMapping(value = "/all")
    public ResponseEntity<List<HashMap<String, Object>>> execute() {
        return ResponseEntity.status(HttpStatus.OK).body(new TourFindAllResponse(all.execute()).response());
    }
}
