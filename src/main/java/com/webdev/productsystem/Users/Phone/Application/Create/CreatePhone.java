package com.webdev.productsystem.Users.Phone.Application.Create;


import com.webdev.productsystem.Users.Phone.Domain.Phone;
import com.webdev.productsystem.Users.Phone.Domain.Ports.PhoneRepository;
import com.webdev.productsystem.Users.Phone.Domain.ValueObjects.PhoneCountryCode;
import com.webdev.productsystem.Users.Phone.Domain.ValueObjects.PhoneId;
import com.webdev.productsystem.Users.Phone.Domain.ValueObjects.PhoneNumber;

public class CreatePhone {
    private final PhoneRepository repository ;

    public CreatePhone(PhoneRepository repository) {
        this.repository = repository;
    }

    public void execute(String id, String countryCode, String phoneNumber){

        this.repository.save(Phone.create(new PhoneId(id), new PhoneCountryCode(countryCode), new PhoneNumber(phoneNumber),null));

    }
}
