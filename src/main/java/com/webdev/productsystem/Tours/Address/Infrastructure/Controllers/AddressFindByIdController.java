package com.webdev.productsystem.Tours.Address.Infrastructure.Controllers;

import com.webdev.productsystem.Tours.Address.Application.Find.AddressByIdFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/address")
public class AddressFindByIdController {
    @Autowired
    private AddressByIdFinder finder;

    @GetMapping("/{addressId}")
    public ResponseEntity<HashMap<String, Object>> execute(@PathVariable(value = "addressId") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(finder.execute(id).data());
    }
}
