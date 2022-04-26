package com.webdev.productsystem.Users.Phone.Application.Create;


import com.webdev.productsystem.Users.Phone.Domain.Exceptions.PhoneExistingValue;
import com.webdev.productsystem.Users.Phone.Domain.Phone;
import com.webdev.productsystem.Users.Phone.Domain.Ports.PhoneRepository;
import com.webdev.productsystem.Users.Phone.Domain.Services.ValidateExistence;
import com.webdev.productsystem.Users.Phone.Domain.ValueObjects.PhoneCountryCode;
import com.webdev.productsystem.Users.Phone.Domain.ValueObjects.PhoneId;
import com.webdev.productsystem.Users.Phone.Domain.ValueObjects.PhoneNumber;

import java.util.Optional;

public class CreatePhone {
    private final PhoneRepository repository ;
    private ValidateExistence validateExistence;

    public CreatePhone(PhoneRepository repository) {
        this.repository = repository;
    }

    public void execute(String id, String countryCode, String phoneNumber){
        validate(phoneNumber);
        this.repository.save(Phone.create(new PhoneId(id), new PhoneCountryCode(countryCode), new PhoneNumber(phoneNumber),null));

    }
    private void validate(String phoneNumber) {
        Optional<Phone> estate = repository.findByNumber(new PhoneNumber(phoneNumber));
        if(estate.isPresent())
            throw new PhoneExistingValue("The phone with number " + phoneNumber + " already exists");
    }


}
