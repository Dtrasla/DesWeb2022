package com.webdev.productsystem.Tours.Hotel.Infrastructure.Controllers;

import com.webdev.productsystem.Shared.Infrastruture.Schema.ErrorSchema;
import com.webdev.productsystem.Tours.Hotel.Application.Delete.HotelRemover;
import com.webdev.productsystem.Tours.Hotel.Domain.Exceptions.HotelNotExists;
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
@RequestMapping(value = "/hotel")
@Tag(name = "Hotel", description = "Hotel REST API")
public class HotelDeleteController {
    @Autowired
    private HotelRemover remover;

    @Operation(summary = "Delete a hotel", description = "Delete a hotel that already exits in the system", tags = {"Hotel"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Hotel deleted"),
            @ApiResponse(responseCode = "404", description = "Hotel not found", content = @Content(schema = @Schema(implementation = ErrorSchema.class))),
    })
    @DeleteMapping(value = "/delete/{hotelId}")
    @CrossOrigin("*")
    public ResponseEntity execute(@PathVariable(value = "hotelId") String id) {
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
