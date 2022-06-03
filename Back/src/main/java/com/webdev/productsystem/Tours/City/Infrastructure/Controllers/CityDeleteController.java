package com.webdev.productsystem.Tours.City.Infrastructure.Controllers;

import com.webdev.productsystem.Tours.City.Application.Delete.DeleteCity;
import com.webdev.productsystem.Tours.Hotel.Application.Delete.HotelRemover;
import com.webdev.productsystem.Tours.Tour.Application.Delete.DeleteTour;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "City", description = "City REST API")
@RequestMapping(value = "/city")
public class CityDeleteController {
    @Autowired
    private DeleteCity remover;

    @DeleteMapping(value = "/delete/{cityId}")
    @CrossOrigin("*")
    public ResponseEntity execute(@PathVariable(value = "cityId") String id) {
        remover.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
