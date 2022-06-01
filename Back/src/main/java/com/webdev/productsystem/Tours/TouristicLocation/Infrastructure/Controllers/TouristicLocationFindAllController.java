package com.webdev.productsystem.Tours.TouristicLocation.Infrastructure.Controllers;

import com.webdev.productsystem.Tours.Hotel.Application.All.HotelFindAll;
import com.webdev.productsystem.Tours.Hotel.Application.All.HotelFindAllResponse;
import com.webdev.productsystem.Tours.TouristicLocation.Application.All.TouristicLocationFindAll;
import com.webdev.productsystem.Tours.TouristicLocation.Application.All.TouristicLocationFindAllResponse;
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
@RequestMapping(value = "/touristicLocation")
@Tag(name = "Touristic Location", description = "Touristic Location REST API")
public class TouristicLocationFindAllController {
    @Autowired
    private TouristicLocationFindAll all;

    @Operation(summary = "Get all the touristic locations", description = "Find all the touristic locations stored in the system", tags = {"TouristicLocation"})
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Touristic Location found") })
    @GetMapping(value = "/all")
    public ResponseEntity<List<HashMap<String, Object>>> execute() {
        return ResponseEntity.status(HttpStatus.OK).body(new TouristicLocationFindAllResponse(all.execute()).response());
    }

}