package com.webdev.productsystem.Tours.Tour.Infrastructure.Controllers;

import com.webdev.productsystem.Shared.Infrastruture.Schema.ErrorSchema;
import com.webdev.productsystem.Tours.Tour.Application.Update.TourDateUpdater;
import com.webdev.productsystem.Tours.Tour.Application.Update.TourNameUpdater;
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
@RequestMapping(value = "tour")
@Tag(name = "Tour", description = "Tour REST API")
public class TourUpdateController {
    @Autowired
    private TourNameUpdater nameUpdater;

    @Autowired
    private TourDateUpdater dateUpdater;

    @Operation(summary = "Update a tour", description = "Modify the values of a tour in the system", tags = {"Address"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tour updated"),
            @ApiResponse(responseCode = "404", description = "Tour not found", content = @Content(schema = @Schema(implementation = ErrorSchema.class))),
    })
    @PutMapping(value = "/update/{tourId}")
    public ResponseEntity execute(@PathVariable(value = "tourId") String id, @RequestBody TourUpdateController.TourUpdaterRequest request) {
        nameUpdater.execute(id, request.name);
        dateUpdater.execute(id, request.date);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @ExceptionHandler(TourNotFound.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ResponseEntity<HashMap> handleNotExistingHotel(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new HashMap<>() {{
            put("error", e.getMessage());
        }});
    }

    static class TourUpdaterRequest {
        @Schema(description = "Tour name", example = "Tour por Barcelona")
        private String name;

        @Schema(description = "Tour date, maximum 10 characters", example = "01/01/2022")
        private String date;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }
    }
}
