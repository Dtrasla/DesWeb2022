package com.webdev.productsystem.Tours.Hotel.Infrastructure.Controllers;

import com.webdev.productsystem.Shared.Infrastruture.Schema.ErrorSchema;
import com.webdev.productsystem.Tours.Hotel.Application.Create.HotelCreator;
import com.webdev.productsystem.Tours.Hotel.Domain.Exceptions.HotelAlreadyExists;
import com.webdev.productsystem.Tours.Hotel.Domain.Exceptions.HotelNameInvalidLength;
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
public class HotelCreateController {
    @Autowired
    private HotelCreator creator;

    @Operation(summary = "Create new hotel", description = "Add a new hotel to the system", tags = {"Hotel"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Hotel created"),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content(schema = @Schema(implementation = ErrorSchema.class))),
            @ApiResponse(responseCode = "409", description = "Hotel already exists", content = @Content(schema = @Schema(implementation = ErrorSchema.class)))
    })
    @PostMapping(value = "/create")
    public ResponseEntity execute(@RequestBody HotelCreatorRequest request) {
        creator.execute(request.getId(), request.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @ExceptionHandler(HotelNameInvalidLength.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<HashMap> handleBadRequest(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new HashMap<>() {{
            put("error", e.getMessage());
        }});
    }

    @ExceptionHandler(HotelAlreadyExists.class)
    @ResponseStatus(code = HttpStatus.CONFLICT)
    public ResponseEntity<HashMap> handleDuplicatedHotel(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new HashMap<>() {{
            put("error", e.getMessage());
        }});
    }

    static class HotelCreatorRequest {
        @Schema(description = "Hotel id", example = "e255f441-70a6-4e6a-896a-dac35607a4bd")
        private String id;

        @Schema(description = "Hotel name, between 5 and 25 characters", example = "Marriott Bogotá")
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
