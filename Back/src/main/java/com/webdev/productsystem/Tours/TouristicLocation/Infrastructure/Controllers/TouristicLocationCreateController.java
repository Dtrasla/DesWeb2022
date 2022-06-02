package com.webdev.productsystem.Tours.TouristicLocation.Infrastructure.Controllers;

import com.webdev.productsystem.Shared.Infrastruture.Schema.ErrorSchema;
import com.webdev.productsystem.Tours.TouristicLocation.Application.Create.TouristicLocationCreator;
import com.webdev.productsystem.Tours.TouristicLocation.Domain.Exceptions.TouristicLocationAlreadyExists;
import com.webdev.productsystem.Tours.TouristicLocation.Domain.Exceptions.TouristicLocationNameInvalidLength;
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
public class TouristicLocationCreateController {
    @Autowired
    private TouristicLocationCreator creator;

    @Operation(summary = "Create new touristic location", description = "Add a new touristic location to the system", tags = {"TouristicLocation"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Touristic location created"),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content(schema = @Schema(implementation = ErrorSchema.class))),
            @ApiResponse(responseCode = "409", description = "Touristic location already exists", content = @Content(schema = @Schema(implementation = ErrorSchema.class)))
    })
    @PostMapping(value = "/create")
    public ResponseEntity execute(@RequestBody com.webdev.productsystem.Tours.TouristicLocation.Infrastructure.Controllers.TouristicLocationCreateController.TouristicLocationCreatorRequest request) {
        creator.execute(request.getId(), request.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @ExceptionHandler(TouristicLocationNameInvalidLength.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<HashMap> handleBadRequest(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new HashMap<>() {{
            put("error", e.getMessage());
        }});
    }

    @ExceptionHandler(TouristicLocationAlreadyExists.class)
    @ResponseStatus(code = HttpStatus.CONFLICT)
    public ResponseEntity<HashMap> handleDuplicatedHotel(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new HashMap<>() {{
            put("error", e.getMessage());
        }});
    }

    static class  TouristicLocationCreatorRequest{
        @Schema(description = "Touristic location id", example = "d0d96c6b-71b0-442b-b905-232710593911")
        private String id;

        @Schema(description = "Touristic location name, between 5 and 25 characters", example = "Monserrate")
        private String name;

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
    }
}
