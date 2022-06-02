package com.webdev.productsystem.Users.Phone.Infrastructure.Controllers;

import com.webdev.productsystem.Shared.Infrastruture.Schema.PhoneErrorSchema;
import com.webdev.productsystem.Users.Phone.Application.Create.PhoneCreate;
import com.webdev.productsystem.Users.Phone.Domain.Exceptions.*;
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
@RequestMapping(value = "/phone")
@Tag(name = "Phone", description = "Phone rest API")
public class PhoneCreateController {
    @Autowired
    private PhoneCreate creator;

    @Operation(summary = "Create a new phone", description = " Create a New Phone in the System", tags ={"Phone"})

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description= "Phone created"),
            @ApiResponse(responseCode = "400", description= "Invalid Phone input", content= @Content(schema = @Schema(implementation = PhoneErrorSchema.class))),
            @ApiResponse(responseCode = "409", description= "Phone already exists", content= @Content(schema = @Schema(implementation = PhoneErrorSchema.class))),
            @ApiResponse(responseCode = "404", description= "Phone not found"),

    })
    @PostMapping(value = "/create")
    public ResponseEntity execute(@RequestBody PhoneCreatorRequest request) {
        creator.execute(request.getId(), request.getCountryCode(), request.getNumber(), request.getUserId());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @ExceptionHandler({PhoneInvalidNumberLength.class, PhoneInvalidCountryCodeLength.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<HashMap> handleBadRequestBecauseLength(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new HashMap<>() {{
            put("error", e.getMessage());
        }});
    }
    @ExceptionHandler({PhoneInvalidNumberString.class, PhoneInvalidCountryCodeString.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<HashMap> handleBadRequestBecauseString(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new HashMap<>() {{
            put("error", e.getMessage());
        }});
    }

    @ExceptionHandler(PhoneExistingNumberValue.class)
    @ResponseStatus(code = HttpStatus.CONFLICT)
    public ResponseEntity<HashMap> handleDuplicatedNumberPhone(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new HashMap<>() {{
            put("error", e.getMessage());
        }});
    }

    @ExceptionHandler(PhoneExistingIdValue.class)
    @ResponseStatus(code = HttpStatus.CONFLICT)
    public ResponseEntity<HashMap> handleDuplicatedIdPhone(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new HashMap<>() {{
            put("error", e.getMessage());
        }});
    }

    @ExceptionHandler(PhoneNotFound.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ResponseEntity<HashMap> handleNotExistingPhone(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new HashMap<>() {{
            put("error", e.getMessage());
        }});
    }

    static class PhoneCreatorRequest {
        @Schema (description = "Phone ID", example= "6ee88824-b7cb-48d2-89e7-7b51d107faf5")
        private String id;
        @Schema (description = "Phone country code", example= "+1")
        private String countryCode;

        @Schema (description = "Phone number", example= "312-345-6789")
        private String number;

        @Schema (description = "User Id", example= "8dbafb1e-e7be-4ec0-8370-d7a87a6bb67c")
        private String userId;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }



        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getCountryCode() {
            return countryCode;
        }

        public void setCountryCode(String countryCode) {
            this.countryCode = countryCode;
        }
    }
}