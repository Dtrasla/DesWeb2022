package com.webdev.productsystem.Users.Phone.Domain.Services;

import com.webdev.productsystem.Users.Phone.Domain.Exceptions.PhoneExistingValue;
import com.webdev.productsystem.Users.Phone.Domain.Exceptions.PhoneNotFound;
import com.webdev.productsystem.Users.Phone.Domain.Phone;
import com.webdev.productsystem.Users.Phone.Domain.Ports.PhoneRepository;
import com.webdev.productsystem.Users.Phone.Domain.ValueObjects.PhoneId;
import com.webdev.productsystem.Users.Phone.Domain.ValueObjects.PhoneNumber;

import java.util.Optional;

public class ValidateExistence {
    private final PhoneRepository repository;

    public ValidateExistence(PhoneRepository repository) {
        this.repository = repository;
    }

    public Phone execute(String phoneNumber){
        Optional<Phone> estateOptional = repository.findByNumber(new PhoneNumber(phoneNumber));
        if(estateOptional.isEmpty())
            throw new PhoneNotFound("El inmueble con id " + phoneNumber + " no se encontró");
        return estateOptional.get();
    }
}
