package com.webdev.productsystem.Users.Phone.Application.Update;

import com.webdev.productsystem.Users.Phone.Domain.Phone;
import com.webdev.productsystem.Users.Phone.Domain.Ports.PhoneRepository;
import com.webdev.productsystem.Users.Phone.Domain.Services.ValidateExistence;
import com.webdev.productsystem.Users.Phone.Domain.ValueObjects.PhoneId;
import com.webdev.productsystem.Users.Phone.Domain.ValueObjects.PhoneNumber;

public class UpdatePhoneNumber {
    private final PhoneRepository repository ;
    private ValidateExistence validateExistence;


    public UpdatePhoneNumber(PhoneRepository repository) {
        this.repository = repository;
    }
    public void execute(String phoneNumber, String newPhoneNumber){
        Phone phone = validateExistence.execute(phoneNumber);
        phone.updatePhoneNumber(new PhoneNumber(newPhoneNumber));
        repository.save(phone);
    }
}
