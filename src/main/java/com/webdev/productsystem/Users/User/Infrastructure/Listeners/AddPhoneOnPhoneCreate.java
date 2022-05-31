package com.webdev.productsystem.Users.User.Infrastructure.Listeners;

import com.webdev.productsystem.Users.Phone.Domain.DomainEvents.PhoneCreatedDomainEvent;

public final class AddPhoneOnPhoneCreate {

    //private AddPhone adder;

    public void on(PhoneCreatedDomainEvent event){
        System.out.println("El evento llego " + event.getNumber());


    }


}
