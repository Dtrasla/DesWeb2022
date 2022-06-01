
package com.webdev.productsystem.Tours.Tour.Infrastructure.Controllers;

import com.webdev.productsystem.Shared.Infrastruture.Schema.ErrorSchema;
import com.webdev.productsystem.Tours.Hotel.Application.Find.HotelByIdFinder;
import com.webdev.productsystem.Tours.Tour.Application.Find.FindTourById;

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
public class TourFindByIdController {
    @Autowired
    private FindTourById finder;

    @Operation(summary = "Find a tour by id", description = "Find and retrieves a tour if it's id is found in the system", tags = {"Tour"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Tour found"),
            @ApiResponse(responseCode = "404", description = "Tour not found", content = @Content(schema = @Schema(implementation = ErrorSchema.class))),
    })
    @GetMapping("/{tourId}")
    public ResponseEntity<HashMap<String, Object>> execute(@PathVariable(value = "tourId") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(finder.execute(id).data());
    }

    @ExceptionHandler(TourNotFound.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ResponseEntity<HashMap> handleNotExistingHotel(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new HashMap<>() {{
            put("error", e.getMessage());
        }});
    }
}
