package com.webdev.productsystem.Tours.Address.Infrastructure.Controllers;

import com.webdev.productsystem.Shared.Infrastruture.Schema.ErrorSchema;
import com.webdev.productsystem.Tours.Address.Application.Update.AddressDataUpdater;
import com.webdev.productsystem.Tours.Address.Application.Update.AddressZipCodeUpdater;
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
public class AddressUpdateController {
    @Autowired
    private AddressDataUpdater dataUpdater;
    @Autowired
    private AddressZipCodeUpdater zipCodeUpdater;

    @Operation(summary = "Update an address", description = "Modify the values of an address in the system", tags = {"Address"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Address updated"),
            @ApiResponse(responseCode = "404", description = "Address not found", content = @Content(schema = @Schema(implementation = ErrorSchema.class))),
    })
    @PutMapping(value = "/update/{addressId}")
    @CrossOrigin("*")
    public ResponseEntity execute(@PathVariable (value = "addressId") String id, @RequestBody AddressUpdaterRequest request) {
        dataUpdater.execute(id, request.data);
        zipCodeUpdater.execute(id, request.zipCode);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @ExceptionHandler(AddressNotExists.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ResponseEntity<HashMap> handleNotExistingHotel(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new HashMap<>() {{
            put("error", e.getMessage());
        }});
    }

    static class AddressUpdaterRequest {
        @Schema(description = "Address data", example = "Cl. 152 # 58C - 50")
        String data;

        @Schema(description = "Address zip code", example = "111156")
        String zipCode;

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public String getZipCode() {
            return zipCode;
        }

        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
        }
    }
}
