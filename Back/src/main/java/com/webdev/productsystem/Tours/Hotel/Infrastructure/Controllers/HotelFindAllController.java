package com.webdev.productsystem.Tours.Hotel.Infrastructure.Controllers;

import com.webdev.productsystem.Shared.Infrastruture.Schema.ErrorSchema;
import com.webdev.productsystem.Tours.Hotel.Application.All.HotelFindAll;
import com.webdev.productsystem.Tours.Hotel.Application.All.HotelFindAllResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
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
@RequestMapping(value = "/hotel")
@Tag(name = "Hotel", description = "Hotel REST API")
public class HotelFindAllController {
    @Autowired
    private HotelFindAll all;

    @Operation(summary = "Get all the hotels", description = "Find all the hotels stored in the system", tags = {"Hotel"})
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Hotels found") })
    @GetMapping(value = "/all")
    public ResponseEntity<List<HashMap<String, Object>>> execute() {
        return ResponseEntity.status(HttpStatus.OK).body(new HotelFindAllResponse(all.execute()).response());
    }

}
