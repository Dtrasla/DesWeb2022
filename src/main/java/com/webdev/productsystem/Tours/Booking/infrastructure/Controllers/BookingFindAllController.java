package com.webdev.productsystem.Tours.Booking.Infrastructure.Controllers;
import com.webdev.productsystem.Tours.Booking.Application.Find.BookingFindAll;
import com.webdev.productsystem.Tours.Booking.Application.Find.BookingFindAllResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/Booking")
public class BookingFindAllController {
    @Autowired
    private BookingFindAll all;

    @GetMapping(value = "/all")
    public ResponseEntity<List<HashMap<String, Object>>> execute() {
        return ResponseEntity.status(HttpStatus.OK).body(new BookingFindAllResponse(all.execute()).response());
    }

}

