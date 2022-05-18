package com.webdev.productsystem.Tours.Booking.infrastructure.Controllers;
import com.webdev.productsystem.Tours.Booking.Application.Find.FindBookingById;
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
@RequestMapping(value = "/Booking")
public class BookingFindById {
    /*@Autowired
    private BookingFindAll all;

    @GetMapping(value = "/all")
    public ResponseEntity<List<HashMap<String, Object>>> execute() {
        return ResponseEntity.status(HttpStatus.OK).body(new BookingFindAllResponse(all.execute()).response());
    }*/
    @Autowired
    private FindBookingById finder;

    @GetMapping("/{tourId}")
    public ResponseEntity<HashMap<String, Object>> execute(@PathVariable(value = "cityId") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(finder.execute(id).data());
    }

}

