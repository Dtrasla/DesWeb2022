package com.webdev.productsystem.Users.User.Infrastructure.Listeners;

import com.webdev.productsystem.Users.Phone.Domain.DomainEvents.PhoneCreatedDomainEvent;
import com.webdev.productsystem.Users.User.Application.AddPhone.AddPhone;

public final class AddPhoneOnPhoneCreate {

    private AddPhone adder;

    public AddPhoneOnPhoneCreate(AddPhone adder) {
        this.adder = adder;
    }

    public void on(PhoneCreatedDomainEvent event){
        System.out.println("El evento llego " + event.getNumber());
        this.adder.execute(event.getUserId(), event.getCountryCode(), event.getNumber(), event.getId());
    }
}
