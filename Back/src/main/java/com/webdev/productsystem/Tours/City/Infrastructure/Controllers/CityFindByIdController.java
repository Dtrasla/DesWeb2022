
package com.webdev.productsystem.Tours.City.Infrastructure.Controllers;

import com.webdev.productsystem.Tours.City.Application.Find.FindCityById;
import com.webdev.productsystem.Tours.Hotel.Application.Find.HotelByIdFinder;
import com.webdev.productsystem.Tours.Tour.Application.Find.FindTourById;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/city")
public class CityFindByIdController {
    @Autowired
    private FindCityById finder;

    @GetMapping("/{tourId}")
    public ResponseEntity<HashMap<String, Object>> execute(@PathVariable(value = "cityId") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(finder.execute(id).data());
    }
}
