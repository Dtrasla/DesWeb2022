package com.webdev.productsystem.Users.User.Infrastructure.Controllers;


import com.webdev.productsystem.Tours.Ticket.Domain.Exceptions.InvalidDate;
import com.webdev.productsystem.Tours.Ticket.Infrastructure.Controllers.TicketCreateController;
import com.webdev.productsystem.Users.User.Application.Create.UserCreator;
import com.webdev.productsystem.Users.User.Domain.Exceptions.InvalidPassword;
import com.webdev.productsystem.Users.User.Domain.Exceptions.InvalidUserEmail;
import com.webdev.productsystem.Users.User.Domain.Exceptions.InvalidUserName;
import com.webdev.productsystem.Users.User.Domain.Exceptions.LenghtInvalid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/user")
public class UserCreateController {
    @Autowired
    private UserCreator creator;

    @PostMapping(value = "/create")
    public ResponseEntity execute(@RequestBody UserCreatorRequest request) {
        creator.execute(request.getId(), request.getEmail(), request.getPassword(), request.getName(), request.getLastName(), request.getBirthday(), request.getGender());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @ExceptionHandler(InvalidUserName.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<HashMap> handleBadRequest(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new HashMap<>() {{
            put("error", e.getMessage());
        }});
    }

    @ExceptionHandler(InvalidUserEmail.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<HashMap> handleInvalidEmail(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new HashMap<>() {{
            put("error", e.getMessage());
        }});
    }

    @ExceptionHandler(InvalidPassword.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<HashMap> handleInvalidPassword(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new HashMap<>() {{
            put("error", e.getMessage());
        }});
    }

    @ExceptionHandler(LenghtInvalid.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<HashMap> handleInvalidLength(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new HashMap<>() {{
            put("error", e.getMessage());
        }});
    }










    static class UserCreatorRequest {

        private String id;
        private String email;
        private String password;
        private String name;
        private String lastName;
        private String birthday;
        private String gender;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }
    }

}
