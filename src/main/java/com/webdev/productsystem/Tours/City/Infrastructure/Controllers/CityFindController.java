package com.webdev.productsystem.Tours.City.Infrastructure.Controllers;

import com.webdev.productsystem.Tours.City.Application.All.CityFindAll;
import com.webdev.productsystem.Tours.City.Application.All.CityFindAllResponse;
import com.webdev.productsystem.Tours.City.Domain.City;
import com.webdev.productsystem.Tours.Hotel.Application.All.HotelFindAll;
import com.webdev.productsystem.Tours.Hotel.Application.All.HotelFindAllResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/city")
public class CityFindController {
    @Autowired
    private CityFindAll all;

    @GetMapping(value = "/all")
    public ResponseEntity<List<HashMap<String, Object>>> execute() {
        return ResponseEntity.status(HttpStatus.OK).body(new CityFindAllResponse(all.execute()).response());
    }

    //Just a try
    @GetMapping(value = "/find/{name}")
    public City findByName(@PathVariable String name){
        City validar = new City();
        for (City city : all.execute()) {
            if(name.equals(city.cityName.value())){
                validar = city;
            }
        }
        return validar;
    }

}
