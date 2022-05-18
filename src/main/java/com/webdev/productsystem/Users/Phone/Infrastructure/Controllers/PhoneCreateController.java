package com.webdev.productsystem.Users.Phone.Infrastructure.Controllers;

import com.webdev.productsystem.Users.Phone.Application.Create.PhoneCreate;
import com.webdev.productsystem.Users.Phone.Domain.Exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
@RestController
@RequestMapping(value = "/phone")
public class PhoneCreateController {
    @Autowired
    private PhoneCreate creator;

    @PostMapping(value = "/create")
    public ResponseEntity execute(@RequestBody PhoneCreatorRequest request) {
        creator.execute(request.getId(), request.getNumber(), request.getCountryCode(), request.getUserId());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @ExceptionHandler({PhoneInvalidNumberLength.class, PhoneInvalidCountryCodeLength.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<HashMap> handleBadRequestBecauseLength(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new HashMap<>() {{
            put("error", e.getMessage());
        }});
    }
    @ExceptionHandler({PhoneInvalidNumberString.class, PhoneInvalidCountryCodeString.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<HashMap> handleBadRequestBecauseString(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new HashMap<>() {{
            put("error", e.getMessage());
        }});
    }

    @ExceptionHandler(PhoneExistingNumberValue.class)
    @ResponseStatus(code = HttpStatus.CONFLICT)
    public ResponseEntity<HashMap> handleDuplicatedNumberPhone(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new HashMap<>() {{
            put("error", e.getMessage());
        }});
    }

    @ExceptionHandler(PhoneExistingIdValue.class)
    @ResponseStatus(code = HttpStatus.CONFLICT)
    public ResponseEntity<HashMap> handleDuplicatedIdPhone(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new HashMap<>() {{
            put("error", e.getMessage());
        }});
    }

    @ExceptionHandler(PhoneNotFound.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ResponseEntity<HashMap> handleNotExistingPhone(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new HashMap<>() {{
            put("error", e.getMessage());
        }});
    }

    static class PhoneCreatorRequest {
        private String id;
        private String countryCode;
        private String number;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        private String userId;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getCountryCode() {
            return countryCode;
        }

        public void setCountryCode(String countryCode) {
            this.countryCode = countryCode;
        }
    }
}