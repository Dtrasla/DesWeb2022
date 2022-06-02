package com.webdev.productsystem.Users.Phone.Domain.Services;

import com.webdev.productsystem.Users.Phone.Domain.Exceptions.PhoneNotFound;
import com.webdev.productsystem.Users.Phone.Domain.Phone;
import com.webdev.productsystem.Users.Phone.Domain.Ports.PhoneRepository;
import com.webdev.productsystem.Users.Phone.Domain.ValueObjects.PhoneId;

import java.util.Optional;

public class ValidateExistence {
    private final PhoneRepository repository;

    public ValidateExistence(PhoneRepository repository) {
        this.repository = repository;
    }

    public Phone execute(String phoneId){
        Optional<Phone> phoneOptional = repository.findById(new PhoneId(phoneId));
        if(phoneOptional.isEmpty())
            throw new PhoneNotFound("The phone with id " + phoneId + " did not find");
        return phoneOptional.get();
    }
}
