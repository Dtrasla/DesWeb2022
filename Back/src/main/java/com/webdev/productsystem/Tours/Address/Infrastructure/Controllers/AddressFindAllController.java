package com.webdev.productsystem.Tours.Address.Infrastructure.Controllers;

import com.webdev.productsystem.Tours.Address.Application.All.AddressFindAll;
import com.webdev.productsystem.Tours.Address.Application.All.AddressFindAllResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/address")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET})
@Tag(name = "Address", description = "Address REST API")
public class AddressFindAllController {
    @Autowired
    private AddressFindAll all;

    @Operation(summary = "Get all the addresses", description = "Find all the addresses stored in the system", tags = {"Address"})
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Addresses found") })
    @GetMapping(value = "/all")
    @CrossOrigin("*")
    public ResponseEntity<List<HashMap<String, Object>>> execute() {
        return ResponseEntity.status(HttpStatus.OK).body(new AddressFindAllResponse(all.execute()).response());
    }
}
