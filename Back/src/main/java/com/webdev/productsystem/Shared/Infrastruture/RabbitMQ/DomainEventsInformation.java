package com.webdev.productsystem.Shared.Infrastruture.RabbitMQ;

import com.webdev.productsystem.Shared.Domain.Bus.Event.DomainEvent;
import com.webdev.productsystem.Tours.Address.Domain.DomainEvents.AddressCreatedDomainEvent;
import com.webdev.productsystem.Tours.TouristicLocation.Domain.DomainEvents.TouristicLocationCreatedDomainEvent;
import com.webdev.productsystem.Users.Phone.Domain.DomainEvents.PhoneCreatedDomainEvent;

import java.util.HashMap;

public class DomainEventsInformation {


        private final HashMap<String, Class<? extends DomainEvent>> indexedDomainEvent = new HashMap<>();
        private final HashMap<String, String> domainEventSubscriber = new HashMap<>();

        public DomainEventsInformation(){
            indexedDomainEvent.put(
                    "add.phone",
                    PhoneCreatedDomainEvent.class
            );
            indexedDomainEvent.put(
                    "add.address",
                    AddressCreatedDomainEvent.class
            );
            indexedDomainEvent.put(
                    "add.touristicLocation",
                    TouristicLocationCreatedDomainEvent.class
            );
            domainEventSubscriber.put(
                    "productSystem.users.phone.add.phone",
                    "AddPhoneOnPhoneCreate"
            );
            domainEventSubscriber.put(
                    "tourSystem.tours.address.add.address",
                    "AddAddressOnAddressCreated"
            );
            domainEventSubscriber.put(
                    "tourSystem.tours.touristicLocation.add.touristicLocation",
                    "AddTouristicLocationOnTouristicLocationCreated"
            );
        }

        public Class<? extends DomainEvent> getDomainEvent(String name){
            return indexedDomainEvent.get(name);

        }

        public boolean validateEventSubscriber(String name){
            return domainEventSubscriber.containsKey(name);
        }

        public String getEventSubscriber(String name){
            return domainEventSubscriber.get(name);
        }






}
