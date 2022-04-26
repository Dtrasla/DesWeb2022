package com.webdev.productsystem.Users.Phone.Application.Update;

import com.webdev.productsystem.Users.Phone.Domain.Phone;
import com.webdev.productsystem.Users.Phone.Domain.Ports.PhoneRepository;
import com.webdev.productsystem.Users.Phone.Domain.Services.ValidateExistence;
import com.webdev.productsystem.Users.Phone.Domain.ValueObjects.PhoneCountryCode;
import com.webdev.productsystem.Users.Phone.Domain.ValueObjects.PhoneId;

public class UpdatePhoneId {
    private final PhoneRepository repository ;
    private ValidateExistence validateExistence;


    public UpdatePhoneId(PhoneRepository repository) {
        this.repository = repository;
    }
    public void execute(String phoneNumber, String phoneId){
        Phone phone = validateExistence.execute(phoneNumber);
        phone.updatePhoneId(new PhoneId(phoneId));
        repository.save(phone);
    }
}
