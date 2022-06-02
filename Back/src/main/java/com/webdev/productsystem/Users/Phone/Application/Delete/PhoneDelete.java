package com.webdev.productsystem.Users.Phone.Application.Delete;

import com.webdev.productsystem.Users.Phone.Domain.Exceptions.PhoneNotFound;
import com.webdev.productsystem.Users.Phone.Domain.Services.ValidateExistence;
import com.webdev.productsystem.Users.Phone.Domain.Phone;
import com.webdev.productsystem.Users.Phone.Domain.Ports.PhoneRepository;

public class PhoneDelete {
    private final PhoneRepository repository ;
    private ValidateExistence validateExistence;

    public PhoneDelete(PhoneRepository repository) {
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
