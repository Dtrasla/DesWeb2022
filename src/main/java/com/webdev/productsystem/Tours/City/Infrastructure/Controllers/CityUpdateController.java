package com.webdev.productsystem.Tours.City.Infrastructure.Controllers;

import java.util.HashMap;

import com.webdev.productsystem.Tours.City.Application.Delete.DeleteCity;
import com.webdev.productsystem.Tours.City.Application.Update.UpdateCityCountry;
import com.webdev.productsystem.Tours.City.Application.Update.UpdateCityName;
import com.webdev.productsystem.Tours.Hotel.Application.Delete.HotelRemover;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping(value = "/city")
public class CityUpdateController {

    @Autowired
    private UpdateCityCountry updateCityCountry;
    @Autowired
    private UpdateCityName updateCityName;

    @PutMapping(value = "/")
    public ResponseEntity execute(@RequestBody CityUpdateRequest request){
        updateCityCountry.execute(request.id, request.country);
        updateCityName.execute(request.id, request.name);
        //gateUpdater.execute(request.ticketId, request.gate);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    /*@ExceptionHandler({TicketNotFound.class})
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ResponseEntity<HashMap> handleBadRequest(RuntimeException exception) {
        HashMap<String, String> response = new HashMap<>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }*/


    static class CityUpdateRequest {
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
