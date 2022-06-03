package com.webdev.productsystem.Users.User.Infrastructure.Controllers;


import com.webdev.productsystem.Shared.Infrastruture.Schema.UserErrorSchema;
import com.webdev.productsystem.Tours.Ticket.Domain.Exceptions.InvalidDate;
import com.webdev.productsystem.Tours.Ticket.Domain.Exceptions.TicketAlreadyExists;
import com.webdev.productsystem.Tours.Ticket.Infrastructure.Controllers.TicketCreateController;
import com.webdev.productsystem.Users.User.Application.Create.UserCreator;
import com.webdev.productsystem.Users.User.Domain.Exceptions.*;
import com.webdev.productsystem.Users.User.Domain.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@Tag(name = "User", description = "User REST API")
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
    @CrossOrigin("*")
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


    @ExceptionHandler(UserAlreadyExist.class)
    @ResponseStatus(code = HttpStatus.CONFLICT)
    public ResponseEntity<HashMap> handleUserAlreadyExists(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new HashMap<>() {{
            put("error", e.getMessage());
        }});
    }

    static class UserCreatorRequest {

        @Schema(description = "User id", example= "60101238-6c2f-4da1-854c-1dfe1478c20d")
        private String id;

        @Schema(description = "User Email", example= "juancamilo@gmail.com)")
        private String email;

        @Schema(description = "User Password", example= "123456ABcd")
        private String password;

        @Schema(description = "User Name", example= "Juan Camilo")
        private String name;

        @Schema(description = "User LastName", example= "Gonzalez")
        private String lastName;

        @Schema(description = "User Birthday", example= "12/3/2000")
        private String birthday;

        @Schema(description = "User Name", example= "Masculino")
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
