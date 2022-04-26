package com.webdev.productsystem.Tours.Address.Infrastructure.Controllers;

import com.webdev.productsystem.Tours.Address.Application.Delete.AddressRemover;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
