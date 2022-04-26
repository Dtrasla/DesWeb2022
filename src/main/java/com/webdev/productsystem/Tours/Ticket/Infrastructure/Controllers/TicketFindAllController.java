package com.webdev.productsystem.Tours.Ticket.Infrastructure.Controllers;
import com.webdev.productsystem.Tours.Ticket.Application.Find.TicketFindAll;
import com.webdev.productsystem.Tours.Ticket.Application.Find.TicketFindAllResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/ticket")
public class TicketFindAllController {
    @Autowired
    private TicketFindAll all;

    @GetMapping(value = "/all")
    public ResponseEntity<List<HashMap<String, Object>>> execute() {
        return ResponseEntity.status(HttpStatus.OK).body(new TicketFindAllResponse(all.execute()).response());
    }

}
