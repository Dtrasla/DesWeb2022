package com.webdev.productsystem.Tours.Address.Infrastructure.Controllers;

import com.webdev.productsystem.Tours.Address.Application.Update.AddressDataUpdater;
import com.webdev.productsystem.Tours.Address.Application.Update.AddressZipCodeUpdater;
import com.webdev.productsystem.Tours.Address.Domain.Excpetions.AddressNotExists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/address")
public class AddressUpdateController {
    @Autowired
    private AddressDataUpdater dataUpdater;
    @Autowired
    private AddressZipCodeUpdater zipCodeUpdater;

    @PutMapping(value = "/update/{addressId}")
    public ResponseEntity execute(@PathVariable (value = "addressId") String id, @RequestBody AddressUpdaterRequest request) {
        dataUpdater.execute(id, request.data);
        zipCodeUpdater.execute(id, request.zipCode);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @ExceptionHandler(AddressNotExists.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ResponseEntity<HashMap> handleNotExistingHotel(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new HashMap<>() {{
            put("error", e.getMessage());
        }});
    }

    static class AddressUpdaterRequest {
        String data;
        String zipCode;

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
    }
}
