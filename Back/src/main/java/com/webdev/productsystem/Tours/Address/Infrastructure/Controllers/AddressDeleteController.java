package com.webdev.productsystem.Tours.Address.Infrastructure.Controllers;

import com.webdev.productsystem.Tours.Address.Application.Delete.AddressRemover;
import com.webdev.productsystem.Tours.Address.Domain.Excpetions.AddressNotExists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/address")
public class AddressDeleteController {
    @Autowired
    private AddressRemover remover;

    @DeleteMapping(value = "/delete/{addressId}")
    public ResponseEntity execute(@PathVariable(value = "addressId") String id) {
        remover.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @ExceptionHandler(AddressNotExists.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ResponseEntity<HashMap> handleNotExistingHotel(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new HashMap<>() {{
            put("error", e.getMessage());
        }});
    }
}
