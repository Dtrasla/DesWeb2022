package com.webdev.productsystem.Tours.TouristicLocation.Infrastructure.Controllers;

import com.webdev.productsystem.Shared.Infrastruture.Schema.ErrorSchema;
import com.webdev.productsystem.Tours.TouristicLocation.Application.All.TouristicLocationFindAll;
import com.webdev.productsystem.Tours.TouristicLocation.Application.Find.TouristicLocationByIdFinder;
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
public class TouristicLocationFindByIdController {
    @Autowired
    private TouristicLocationByIdFinder finder;

    @Operation(summary = "Find a touristic location by id", description = "Find and retrieves a touristic location if it's id is found in the system", tags = {"TouristicLocation"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "touristic location found"),
            @ApiResponse(responseCode = "404", description = "touristic location not found", content = @Content(schema = @Schema(implementation = ErrorSchema.class))),
    })
    @GetMapping("/{touristicLocationId}")
    @CrossOrigin("*")
    public ResponseEntity<HashMap<String, Object>> execute(@PathVariable(value = "touristicLocationId") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(finder.execute(id).data());
    }

    @ExceptionHandler(TouristicLocationNotExists.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ResponseEntity<HashMap> handleNotExistingHotel(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new HashMap<>() {{
            put("error", e.getMessage());
        }});
    }
}