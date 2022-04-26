package com.webdev.productsystem.Users.Phone.Application.Update;

import com.webdev.productsystem.Users.Phone.Domain.Phone;
import com.webdev.productsystem.Users.Phone.Domain.Ports.PhoneRepository;
import com.webdev.productsystem.Users.Phone.Domain.Services.ValidateExistence;
import com.webdev.productsystem.Users.Phone.Domain.ValueObjects.PhoneId;
import com.webdev.productsystem.Users.Phone.Domain.ValueObjects.PhoneNumber;

public class PhoneNumberUpdate {
    private final PhoneRepository repository ;
    private ValidateExistence validateExistence;


    public PhoneNumberUpdate(PhoneRepository repository) {
        this.repository = repository;
    }
    public void execute(String phoneId, String phoneNumber){
        Phone phone = validateExistence.execute(phoneId);
        validatePhoneNumber(phoneNumber);
        phone.updatePhoneNumber(new PhoneNumber(phoneNumber));
        repository.save(phone);
    }
    public void validatePhoneNumber(String phoneNumber){
        PhoneNumber pn = new PhoneNumber(phoneNumber);
    }
}
