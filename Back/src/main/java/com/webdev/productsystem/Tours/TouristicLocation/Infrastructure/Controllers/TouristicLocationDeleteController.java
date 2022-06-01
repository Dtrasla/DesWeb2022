package com.webdev.productsystem.Tours.TouristicLocation.Infrastructure.Controllers;

import com.webdev.productsystem.Shared.Infrastruture.Schema.ErrorSchema;
import com.webdev.productsystem.Tours.Hotel.Application.Delete.HotelRemover;
import com.webdev.productsystem.Tours.Hotel.Domain.Exceptions.HotelNotExists;
import com.webdev.productsystem.Tours.TouristicLocation.Application.Delete.TouristicLocationRemover;
import com.webdev.productsystem.Tours.TouristicLocation.Domain.TouristicLocation;
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
public class TouristicLocationDeleteController {

        @Autowired
        private TouristicLocationRemover remover;

        @Operation(summary = "Delete a touristic Location", description = "Delete a touristic Location that already exits in the system", tags = {"TouristicLocation"})
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "Touristic Location deleted"),
                @ApiResponse(responseCode = "404", description = "Touristic Location not found", content = @Content(schema = @Schema(implementation = ErrorSchema.class))),
        })
        @DeleteMapping(value = "/delete/{touristicLocationId}")
        public ResponseEntity execute(@PathVariable(value = "touristicLocationId") String id) {
            remover.execute(id);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }

        @ExceptionHandler(HotelNotExists.class)
        @ResponseStatus(code = HttpStatus.NOT_FOUND)
        public ResponseEntity<HashMap> handleNotExistingHotel(RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new HashMap<>() {{
                put("error", e.getMessage());
            }});
        }


}
