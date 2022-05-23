package com.webdev.productsystem.Users.User.Application.Create;

import com.webdev.productsystem.Tours.Hotel.Domain.Exceptions.HotelAlreadyExists;
import com.webdev.productsystem.Tours.Hotel.Domain.ValueObjects.HotelId;
import com.webdev.productsystem.Tours.Ticket.Domain.Tickets;
import com.webdev.productsystem.Tours.Ticket.Domain.ValueObjects.TicketId;
import com.webdev.productsystem.Users.User.Domain.Exceptions.UserAlreadyExist;
import com.webdev.productsystem.Users.User.Domain.Ports.UserRepository;
import com.webdev.productsystem.Users.User.Domain.User;
import com.webdev.productsystem.Users.User.Domain.ValueObjects.*;
import com.webdev.productsystem.Users.User.Domain.ValueObjects.UserEmail;
import com.webdev.productsystem.Users.User.Domain.ValueObjects.UserId;
import com.webdev.productsystem.Users.User.Domain.ValueObjects.UserPassword;

import java.util.Optional;

public class UserCreator {

    private UserRepository repository;

    public UserCreator(UserRepository repository) {
        this.repository = repository;
    }

    public void execute(String id, String email, String password, String name, String lastName, String birthday, String gender) {
        validate(email);


        repository.save(User.create(new UserId(id), new UserEmail(email), new UserPassword(password), new UserName(name),
                new UserLastName(lastName), new UserBirthday(birthday), new UserGender(gender)));
    }

    private void validate(String email) {
        checkIfAlreadyExists(email);
    }

    private void checkIfAlreadyExists(String id) {
        if(repository.findByEmail(new UserEmail(id)).isPresent())
            throw new UserAlreadyExist("A User with that Email already exists");
    }

}
