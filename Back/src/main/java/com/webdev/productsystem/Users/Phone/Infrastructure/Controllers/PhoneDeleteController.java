package com.webdev.productsystem.Users.Phone.Infrastructure.Controllers;

import com.webdev.productsystem.Users.Phone.Application.Delete.PhoneDelete;
import com.webdev.productsystem.Users.Phone.Domain.Exceptions.PhoneNotFound;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/phone")
@Tag(name = "Phone", description = "Phone rest API")
public class PhoneDeleteController {

    @Autowired
    private PhoneDelete remover;
    @Operation(summary = "Delete a Phone", description = " Delete a Phone from the  System", tags ={"Phone"})

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description= "Phone deleted"),
            @ApiResponse(responseCode = "404", description= "Phone not found"),

    })
    @DeleteMapping(value = "/delete/{phoneId}")
    @CrossOrigin("*")
    public ResponseEntity execute(@PathVariable(value = "phoneId") String id) {
        remover.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
    @ExceptionHandler(PhoneNotFound.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ResponseEntity<HashMap> handleNotExistingPhone(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new HashMap<>() {{
            put("error", e.getMessage());
        }});
    }
}