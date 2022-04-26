package com.webdev.productsystem.Users.Phone.Application.Update;

import com.webdev.productsystem.Users.Phone.Domain.Phone;
import com.webdev.productsystem.Users.Phone.Domain.Ports.PhoneRepository;
import com.webdev.productsystem.Users.Phone.Domain.Services.ValidateExistence;
import com.webdev.productsystem.Users.Phone.Domain.ValueObjects.PhoneCountryCode;
import com.webdev.productsystem.Users.Phone.Domain.ValueObjects.PhoneNumber;

public class PhoneCountryCodeUpdate {
    private final PhoneRepository repository ;
    private ValidateExistence validateExistence;


    public PhoneCountryCodeUpdate(PhoneRepository repository) {
        this.repository = repository;
    }
    public void execute(String id, String countryCode){
        Phone phone = validateExistence.execute(id);
        validateCountryCode(countryCode);
        phone.updatePhoneCountryCode(new PhoneCountryCode(countryCode));
        repository.save(phone);
    }
    public void validateCountryCode(String countryCode){
        PhoneCountryCode cc = new PhoneCountryCode(countryCode);
    }
}
