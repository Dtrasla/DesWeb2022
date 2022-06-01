package com.webdev.productsystem.Tours.Tour.Infrastructure.Controllers;

import com.webdev.productsystem.Shared.Infrastruture.Schema.ErrorSchema;
import com.webdev.productsystem.Tours.Hotel.Application.Delete.HotelRemover;
import com.webdev.productsystem.Tours.Hotel.Domain.Exceptions.HotelNotExists;
import com.webdev.productsystem.Tours.Tour.Application.Delete.DeleteTour;

import com.webdev.productsystem.Tours.Tour.Domain.Exceptions.TourNotFound;
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
@RequestMapping(value = "/tour")
@Tag(name = "Tour", description = "Tour REST API")
public class TourDeleteController {
    @Autowired
    private DeleteTour remover;

    @Operation(summary = "Delete a tour", description = "Delete a tour from the system", tags = {"Tour"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Tour deleted"),
            @ApiResponse(responseCode = "404", description = "Tour not found", content = @Content(schema = @Schema(implementation = ErrorSchema.class))),
    })
    @DeleteMapping(value = "/delete/{tourId}")
    public ResponseEntity execute(@PathVariable(value = "tourId") String id) {
        remover.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @ExceptionHandler(TourNotFound.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ResponseEntity<HashMap> handleNotExistingHotel(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new HashMap<>() {{
            put("error", e.getMessage());
        }});
    }
}
