package com.webdev.productsystem.Tours.Address.Infrastructure.Controllers;

import com.webdev.productsystem.Tours.Address.Application.Create.AddressCreator;
import com.webdev.productsystem.Tours.Hotel.Domain.Exceptions.HotelAlreadyExists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/address")
public class AddressCreateController {
    @Autowired
    private AddressCreator creator;

    @PostMapping(value = "/create")
    public ResponseEntity execute(@RequestBody AddressCreatorRequest request) {
        creator.execute(request.id, request.data, request.zipCode, request.cityId);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @ExceptionHandler(HotelAlreadyExists.class)
    @ResponseStatus(code = HttpStatus.CONFLICT)
    public ResponseEntity<HashMap> handleDuplicatedHotel(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new HashMap<>() {{
            put("error", e.getMessage());
        }});
    }

    static class AddressCreatorRequest {
        String id;
        String data;
        String zipCode;
        String cityId;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public String getZipCode() {
            return zipCode;
        }

        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
        }

        public String getCityId() {
            return cityId;
        }

        public void setCityId(String cityId) {
            this.cityId = cityId;
        }
    }
}
