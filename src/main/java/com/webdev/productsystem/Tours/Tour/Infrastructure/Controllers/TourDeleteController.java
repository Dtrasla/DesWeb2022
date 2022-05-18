package com.webdev.productsystem.Tours.Tour.Infrastructure.Controllers;

import com.webdev.productsystem.Tours.Hotel.Application.Delete.HotelRemover;
import com.webdev.productsystem.Tours.Tour.Application.Delete.DeleteTour;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/tour")
public class TourDeleteController {
    @Autowired
    private DeleteTour remover;

    @DeleteMapping(value = "/delete/{tourId}")
    public ResponseEntity execute(@PathVariable(value = "tourId") String id) {
        remover.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
