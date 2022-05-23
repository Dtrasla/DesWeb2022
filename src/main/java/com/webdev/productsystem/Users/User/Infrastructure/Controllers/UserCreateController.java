package com.webdev.productsystem.Users.User.Infrastructure.Controllers;


import com.webdev.productsystem.Shared.Infrastruture.Schema.UserErrorSchema;
import com.webdev.productsystem.Tours.Ticket.Domain.Exceptions.InvalidDate;
import com.webdev.productsystem.Tours.Ticket.Infrastructure.Controllers.TicketCreateController;
import com.webdev.productsystem.Users.User.Application.Create.UserCreator;
import com.webdev.productsystem.Users.User.Domain.Exceptions.InvalidPassword;
import com.webdev.productsystem.Users.User.Domain.Exceptions.InvalidUserEmail;
import com.webdev.productsystem.Users.User.Domain.Exceptions.InvalidUserName;
import com.webdev.productsystem.Users.User.Domain.Exceptions.LenghtInvalid;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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


    @Operation(summary = "Create a new Ticket", description = " Create a New Ticket in the System", tags ={"Ticket"})

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description= "User created"),
            @ApiResponse(responseCode = "400", description= "Invalid User input", content= @Content(schema = @Schema(implementation = UserErrorSchema.class))),
            @ApiResponse(responseCode = "409", description= "User already exists", content= @Content(schema = @Schema(implementation = UserErrorSchema.class))),

    })


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

        @Schema(description = "User id", example= "6705a4cc-5e59-4f29-8cc5-9ec6e7434d0d")
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
