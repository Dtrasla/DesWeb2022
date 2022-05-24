package com.webdev.productsystem.Tours.TouristicLocation.Infrastructure.Controllers;

import com.webdev.productsystem.Shared.Infrastruture.Schema.ErrorSchema;
import com.webdev.productsystem.Tours.TouristicLocation.Application.Update.TouristicLocationNameUpdater;
import com.webdev.productsystem.Tours.TouristicLocation.Domain.Exceptions.TouristicLocationNotExists;
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
@RequestMapping(value = "/touristicLocation")
@Tag(name = "Touristic Location", description = "Touristic Location REST API")
public class TouristicLocationUpdateController {
    @Autowired
    private TouristicLocationNameUpdater nameUpdater;

    @Operation(summary = "Update a touristic location", description = "Modify the values of a touristic location in the system", tags = {"TouristicLocation"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Touristic Location updated"),
            @ApiResponse(responseCode = "404", description = "Touristic Location not found", content = @Content(schema = @Schema(implementation = ErrorSchema.class))),
    })
    @PutMapping(value = "/update/{touristicLocationId}")
    public ResponseEntity execute(@PathVariable(value = "touristicLocationId") String id, @RequestBody com.webdev.productsystem.Tours.TouristicLocation.Infrastructure.Controllers.TouristicLocationUpdateController.TouristicLocationRequest request) {
        nameUpdater.execute(id, request.name);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @ExceptionHandler(TouristicLocationNotExists.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ResponseEntity<HashMap> handleNotExistingHotel(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new HashMap<>() {{
            put("error", e.getMessage());
        }});
    }

    static class TouristicLocationRequest {
        @Schema(description = "Touristic location name, between 5 and 25 characters", example = "Monserrate")
        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
