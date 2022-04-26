package com.webdev.productsystem.Tours.City.Infrastructure.Controllers;

import com.webdev.productsystem.Tours.City.Application.Create.CreateCity;
import com.webdev.productsystem.Tours.Hotel.Application.Create.HotelCreator;
import com.webdev.productsystem.Tours.Hotel.Domain.Exceptions.HotelAlreadyExists;
import com.webdev.productsystem.Tours.Hotel.Domain.Exceptions.HotelNameInvalidLength;
import com.webdev.productsystem.Tours.Hotel.Domain.Exceptions.HotelNotExists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/city")
public class CityCreateController {
    @Autowired
    private CreateCity creator;

    @PostMapping(value = "/create")
    public ResponseEntity execute(@RequestBody CityCreatorRequest request) {
        creator.execute(request.getId(), request.getName(), request.getCountry());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    /*@ExceptionHandler(HotelNameInvalidLength.class)
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

    @ExceptionHandler(HotelNotExists.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ResponseEntity<HashMap> handleNotExistingHotel(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new HashMap<>() {{
            put("error", e.getMessage());
        }});
    }*/

    static class CityCreatorRequest {
        private String id;
        private String name;
        private String country;

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

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }
    }
}
