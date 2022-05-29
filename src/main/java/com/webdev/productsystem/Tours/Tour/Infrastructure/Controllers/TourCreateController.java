package com.webdev.productsystem.Tours.Tour.Infrastructure.Controllers;

import com.webdev.productsystem.Shared.Infrastruture.Schema.ErrorSchema;
import com.webdev.productsystem.Tours.Tour.Application.Create.CreateTour;

import com.webdev.productsystem.Tours.Tour.Domain.Exceptions.TourAlreadyExists;
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
public class TourCreateController {
    @Autowired
    private CreateTour creator;

    @Operation(summary = "Create new tour", description = "Add a new tour to the system", tags = {"Tour"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Tour created"),
            @ApiResponse(responseCode = "404", description = "Tour not found", content = @Content(schema = @Schema(implementation = ErrorSchema.class))),
            @ApiResponse(responseCode = "409", description = "Tour already exists", content = @Content(schema = @Schema(implementation = ErrorSchema.class)))
    })
    @PostMapping(value = "/create")
    public ResponseEntity execute(@RequestBody TourCreatorRequest request) {
        creator.execute(request.getId(), request.getName(), request.getDate(), request.getTouristicLocationId());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @ExceptionHandler(TourAlreadyExists.class)
    @ResponseStatus(code = HttpStatus.CONFLICT)
    public ResponseEntity<HashMap> handleDuplicatedTour(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new HashMap<>() {{
            put("error", e.getMessage());
        }});
    }

    @ExceptionHandler(TourNotFound.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ResponseEntity<HashMap> handleNotExistingTour(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new HashMap<>() {{
            put("error", e.getMessage());
        }});
    }

    static class TourCreatorRequest {
        private String id;
        private String name;
        private String date;
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

        public void setName(String name) {
            this.name = name;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getTouristicLocationId() {
            return touristicLocationId;
        }

        public void setTouristicLocationId(String touristicLocationId) {
            this.touristicLocationId = touristicLocationId;
        }
    }
}
