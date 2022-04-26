package com.webdev.productsystem.Users.Phone.Application.Delete;

import com.webdev.productsystem.Users.Phone.Domain.Exceptions.PhoneNotFound;
import com.webdev.productsystem.Users.Phone.Domain.Services.ValidateExistence;
import com.webdev.productsystem.Users.Phone.Domain.Exceptions.PhoneExistingValue;
import com.webdev.productsystem.Users.Phone.Domain.Phone;
import com.webdev.productsystem.Users.Phone.Domain.Ports.PhoneRepository;
import com.webdev.productsystem.Users.Phone.Domain.ValueObjects.PhoneNumber;

import java.util.Optional;

public class DeletePhone {
    private final PhoneRepository repository ;
    private ValidateExistence validateExistence;

    public DeletePhone(PhoneRepository repository) {
        this.repository = repository;
    }

    public void execute(String phoneNumber){
        //Find the estate
        Phone estate = validateExistence.execute(phoneNumber);
        if(estate == null)
            throw new PhoneNotFound("We didn't find a phone with the number " + phoneNumber);
        //Delete estate
        repository.delete(estate);
    }

}
