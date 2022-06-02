package com.webdev.productsystem.Users.Phone.Application.Create;


import com.webdev.productsystem.Shared.Domain.Bus.Event.EventBus;
import com.webdev.productsystem.Users.Phone.Domain.Exceptions.PhoneExistingNumberValue;
import com.webdev.productsystem.Users.Phone.Domain.Exceptions.PhoneExistingIdValue;
import com.webdev.productsystem.Users.Phone.Domain.Phone;
import com.webdev.productsystem.Users.Phone.Domain.Ports.PhoneRepository;
import com.webdev.productsystem.Users.Phone.Domain.Services.ValidateExistence;
import com.webdev.productsystem.Users.Phone.Domain.ValueObjects.PhoneCountryCode;
import com.webdev.productsystem.Users.Phone.Domain.ValueObjects.PhoneId;
import com.webdev.productsystem.Users.Phone.Domain.ValueObjects.PhoneNumber;
import com.webdev.productsystem.Users.Phone.Domain.ValueObjects.UserId;

import java.util.Optional;

public class PhoneCreate {
    private final PhoneRepository repository ;
    private ValidateExistence validateExistence;
    private final EventBus eventBus;

    public PhoneCreate(PhoneRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus = eventBus;
    }

    public void execute(String id, String countryCode, String phoneNumber, String userId){
        validate(phoneNumber, id, countryCode);
        Phone ph = Phone.create(new PhoneId(id), new PhoneCountryCode(countryCode), new PhoneNumber(phoneNumber), new UserId(userId));
        this.repository.save(ph);
        System.out.println("🟦 CREATE-PHONE: " + ph.data().toString());
        this.eventBus.publish(ph.pullDomainEvents());

    }
    private void validate(String phoneNumber, String id, String countryCode) {
        Optional<Phone> estate = repository.findByNumber(new PhoneNumber(phoneNumber));
        if(repository.findById(new PhoneId(id)).isPresent())
            throw new PhoneExistingIdValue("A phone with Id" + id + "already exists");
        if(estate.isPresent())
            throw new PhoneExistingNumberValue("The phone with number " + phoneNumber + " already exists");
    }

}
