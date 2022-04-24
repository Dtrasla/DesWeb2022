package com.webdev.productsystem.Users.Phone.Application.Update;

import com.webdev.productsystem.Users.Phone.Domain.Phone;
import com.webdev.productsystem.Users.Phone.Domain.Ports.PhoneRepository;
import com.webdev.productsystem.Users.Phone.Domain.Services.ValidateExistence;
import com.webdev.productsystem.Users.Phone.Domain.ValueObjects.PhoneCountryCode;
import com.webdev.productsystem.Users.Phone.Domain.ValueObjects.PhoneNumber;

public class UpdatePhoneCountryCode {
    private final PhoneRepository repository ;
    private ValidateExistence validateExistence;


    public UpdatePhoneCountryCode(PhoneRepository repository) {
        this.repository = repository;
    }
    public void execute(String phoneNumber, String countryCode){
        Phone phone = validateExistence.execute(phoneNumber);
        phone.updatePhoneCountryCode(new PhoneCountryCode(countryCode));
        repository.save(phone);
    }
}
