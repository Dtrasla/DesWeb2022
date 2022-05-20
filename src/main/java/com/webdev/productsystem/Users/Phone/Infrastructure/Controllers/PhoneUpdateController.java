package com.webdev.productsystem.Users.Phone.Infrastructure.Controllers;

import com.webdev.productsystem.Users.Phone.Application.Update.PhoneCountryCodeUpdate;
import com.webdev.productsystem.Users.Phone.Application.Update.PhoneNumberUpdate;
import com.webdev.productsystem.Users.Phone.Domain.Exceptions.PhoneInvalidCountryCodeLength;
import com.webdev.productsystem.Users.Phone.Domain.Exceptions.PhoneInvalidCountryCodeString;
import com.webdev.productsystem.Users.Phone.Domain.Exceptions.PhoneInvalidNumberLength;
import com.webdev.productsystem.Users.Phone.Domain.Exceptions.PhoneInvalidNumberString;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/phone")
@Tag(name = "Phone", description = "Phone rest API")
public class PhoneUpdateController {
    @Autowired
    private PhoneCountryCodeUpdate countryCodeUpdate;
    @Autowired
    private PhoneNumberUpdate numberUpdate;

    @Operation(summary = "Update an existing phone", description = "Update Phone", tags = {"Phone"})
    @PutMapping(value = "/")
    public ResponseEntity execute(@RequestBody PhoneUpdateRequest request){
        countryCodeUpdate.execute(request.Id, request.countryCode);
        numberUpdate.execute(request.Id, request.number);

        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
    @ExceptionHandler({PhoneInvalidCountryCodeLength.class, PhoneInvalidCountryCodeString.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<HashMap> handleBadRequestBecauseLength(RuntimeException exception) {
        HashMap<String, String> response = new HashMap<>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
    @ExceptionHandler({PhoneInvalidNumberLength.class, PhoneInvalidNumberString.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<HashMap> handleBadRequestBecauseString(RuntimeException exception) {
        HashMap<String, String> response = new HashMap<>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    static class PhoneUpdateRequest{
        private String Id;
        private String number;
        private String countryCode;
        public String getId() {
            return Id;
        }

        public void setId(String id) {
            Id = id;
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



        public PhoneUpdateRequest() {
        }
    }
}
