package com.webdev.productsystem.Tours.Address.Infrastructure.Controllers;

import com.webdev.productsystem.Tours.Address.Application.All.AddressFindAll;
import com.webdev.productsystem.Tours.Address.Application.All.AddressFindAllResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/address")
public class AddressFindAllController {
    @Autowired
    private AddressFindAll all;

    @GetMapping(value = "/all")
    public ResponseEntity<List<HashMap<String, Object>>> execute() {
        return ResponseEntity.status(HttpStatus.OK).body(new AddressFindAllResponse(all.execute()).response());
    }
}
