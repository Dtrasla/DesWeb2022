
package com.webdev.productsystem.Tours.Hotel.Infrastructure.Controllers;

import com.webdev.productsystem.Tours.Hotel.Application.Find.HotelByIdFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/hotel")
public class HotelFindByIdController {
    @Autowired
    private HotelByIdFinder finder;

    @GetMapping("/{hotelId}")
    public ResponseEntity<HashMap<String, Object>> execute(@PathVariable(value = "hotelId") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(finder.execute(id).data());
    }
}
