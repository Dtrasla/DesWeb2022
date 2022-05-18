
package com.webdev.productsystem.Tours.Tour.Infrastructure.Controllers;

import com.webdev.productsystem.Tours.Hotel.Application.Find.HotelByIdFinder;
import com.webdev.productsystem.Tours.Tour.Application.Find.FindTourById;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/tour")
public class TourFindByIdController {
    @Autowired
    private FindTourById finder;

    @GetMapping("/{tourId}")
    public ResponseEntity<HashMap<String, Object>> execute(@PathVariable(value = "tourId") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(finder.execute(id).data());
    }
}
