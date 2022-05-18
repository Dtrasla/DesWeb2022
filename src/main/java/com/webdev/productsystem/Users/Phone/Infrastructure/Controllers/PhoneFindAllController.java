package com.webdev.productsystem.Users.Phone.Infrastructure.Controllers;

import com.webdev.productsystem.Tours.Hotel.Application.All.HotelFindAll;
import com.webdev.productsystem.Tours.Hotel.Application.All.HotelFindAllResponse;
import com.webdev.productsystem.Users.Phone.Application.All.PhoneFindAll;
import com.webdev.productsystem.Users.Phone.Application.All.PhoneFindAllResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/phone")
public class PhoneFindAllController {
    @Autowired
    private PhoneFindAll all;

    @GetMapping(value = "/all")
    public ResponseEntity<List<HashMap<String, Object>>> execute() {
        return ResponseEntity.status(HttpStatus.OK).body(new PhoneFindAllResponse(all.execute()).response());
    }

}