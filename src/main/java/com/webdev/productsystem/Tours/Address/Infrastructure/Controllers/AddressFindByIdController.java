package com.webdev.productsystem.Tours.Address.Infrastructure.Controllers;

import com.webdev.productsystem.Shared.Infrastruture.Schema.ErrorSchema;
import com.webdev.productsystem.Tours.Address.Application.Find.AddressByIdFinder;
import com.webdev.productsystem.Tours.Address.Domain.Excpetions.AddressNotExists;
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
@RequestMapping(value = "/address")
@Tag(name = "Address", description = "Address REST API")
public class AddressFindByIdController {
    @Autowired
    private AddressByIdFinder finder;

    @Operation(summary = "Find a address by id", description = "Find and retrieves a address if it's id is found in the system", tags = {"Address"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Address found"),
            @ApiResponse(responseCode = "404", description = "Address not found", content = @Content(schema = @Schema(implementation = ErrorSchema.class))),
    })
    @GetMapping("/{addressId}")
    public ResponseEntity<HashMap<String, Object>> execute(@PathVariable(value = "addressId") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(finder.execute(id).data());
    }

    @ExceptionHandler(AddressNotExists.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ResponseEntity<HashMap> handleNotExistingHotel(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new HashMap<>() {{
            put("error", e.getMessage());
        }});
    }
}
