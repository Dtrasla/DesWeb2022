package com.webdev.productsystem.Tours.City.Infrastructure.Controllers;

import com.webdev.productsystem.Shared.Infrastruture.Schema.ErrorSchema;
import com.webdev.productsystem.Tours.Address.Application.Update.AddressDataUpdater;
import com.webdev.productsystem.Tours.Address.Application.Update.AddressZipCodeUpdater;
import com.webdev.productsystem.Tours.Address.Domain.Excpetions.AddressNotExists;
import com.webdev.productsystem.Tours.City.Application.Update.CityCountryUpdater;
import com.webdev.productsystem.Tours.City.Application.Update.CityNameUpdater;
import com.webdev.productsystem.Tours.City.Application.Update.CityTourLocationIdUpdater;
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
@RequestMapping(value = "/city")
@Tag(name = "City", description = "City REST API")
public class CityUpdateController {
    @Autowired
    private CityNameUpdater cityNameUpdater;
    @Autowired
    private CityCountryUpdater cityCountryUpdater;
    @Autowired
    private CityTourLocationIdUpdater cityTourLocationIdUpdater;

    @Operation(summary = "Update an address", description = "Modify the values of an address in the system", tags = {"City"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "City updated"),
            @ApiResponse(responseCode = "404", description = "City not found", content = @Content(schema = @Schema(implementation = ErrorSchema.class))),
    })
    @PutMapping(value = "/update/{cityId}")
    @CrossOrigin("*")
    public ResponseEntity execute(@PathVariable (value = "cityId") String id, @RequestBody CityCreatorRequest request) {
        cityNameUpdater.execute(id, request.name);
        cityCountryUpdater.execute(id, request.country);
        cityTourLocationIdUpdater.execute(id, request.touristicLocationId);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @ExceptionHandler(AddressNotExists.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ResponseEntity<HashMap> handleNotExistingHotel(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new HashMap<>() {{
            put("error", e.getMessage());
        }});
    }

    static class CityCreatorRequest {
        @Schema(description = "City id", example = "001")
        private String id;
        @Schema(description = "City name", example = "Santa Marta")
        private String name;
        @Schema(description = "City country", example = "Colombia")
        private String country;
        @Schema(description = "City touristicLocationId", example = "bd8629e1-55b2-498c-99f5-234b280846ef")
        private String touristicLocationId;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setDate(String date) {
            this.country = date;
        }
        public String getCountry() {
            return country;
        }

        public void setCountry(String name) {
            this.name = name;
        }

        public String getTouristicLocationId() {
            return touristicLocationId;
        }

        public void setTouristicLocationId(String touristicLocationId) {
            this.touristicLocationId = touristicLocationId;
        }


    }
}
