package com.webdev.productsystem.Users.Phone.Infrastructure.Controllers;

import com.webdev.productsystem.Users.Phone.Application.Delete.PhoneDelete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/phone")
public class PhoneDeleteController {
    @Autowired
    private PhoneDelete remover;

    @DeleteMapping(value = "/delete/{phoneId}")
    public ResponseEntity execute(@PathVariable(value = "phoneId") String id) {
        remover.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}