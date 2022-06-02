package com.webdev.productsystem.Tours.Hotel.Infrastructure.Controllers;

import com.webdev.productsystem.Tours.Hotel.Application.Update.HotelNameUpdater;
import com.webdev.productsystem.Tours.Hotel.Domain.Exceptions.HotelNotExists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/hotel")
public class HotelUpdateController {
    @Autowired
    private HotelNameUpdater nameUpdater;

    @PutMapping(value = "/update/{hotelId}")
    public ResponseEntity execute(@PathVariable(value = "hotelId") String id, @RequestBody HotelUpdaterRequest request) {
        nameUpdater.execute(id, request.name);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @ExceptionHandler(HotelNotExists.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ResponseEntity<HashMap> handleNotExistingHotel(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new HashMap<>() {{
            put("error", e.getMessage());
        }});
    }

    static class HotelUpdaterRequest {
        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
