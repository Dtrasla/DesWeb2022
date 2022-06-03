package com.webdev.productsystem.Users.Phone.Infrastructure.Controllers;

import com.webdev.productsystem.Tours.Hotel.Application.All.HotelFindAll;
import com.webdev.productsystem.Tours.Hotel.Application.All.HotelFindAllResponse;
import com.webdev.productsystem.Users.Phone.Application.All.PhoneFindAll;
import com.webdev.productsystem.Users.Phone.Application.All.PhoneFindAllResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/phone")
@Tag(name = "Phone", description = "Phone rest API")
public class PhoneFindAllController {
    @Autowired
    private PhoneFindAll all;
    @Operation(summary = "Find all Phones", description = " Find all the phone in the system", tags ={"Phone"})

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description= "All Phones found"),


    })
    @GetMapping(value = "/all")
    @CrossOrigin("*")
    public ResponseEntity<List<HashMap<String, Object>>> execute() {
        return ResponseEntity.status(HttpStatus.OK).body(new PhoneFindAllResponse(all.execute()).response());
    }

}