package com.webdev.productsystem.Tours.City.Infrastructure.Controllers;

import com.webdev.productsystem.Tours.Address.Application.All.AddressFindAll;
import com.webdev.productsystem.Tours.Address.Application.All.AddressFindAllResponse;
import com.webdev.productsystem.Tours.City.Application.All.CityFindAll;
import com.webdev.productsystem.Tours.City.Application.All.CityFindAllResponse;
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
@RequestMapping(value = "/city")
@Tag(name = "City", description = "City REST API")
public class CityFindAllController {
    @Autowired
    private CityFindAll all;

    @Operation(summary = "Get all the cities", description = "Find all the cities stored in the system", tags = {"City"})
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Cities found") })
    @GetMapping(value = "/all")
    public ResponseEntity<List<HashMap<String, Object>>> execute() {
        return ResponseEntity.status(HttpStatus.OK).body(new CityFindAllResponse(all.execute()).response());
    }
}
