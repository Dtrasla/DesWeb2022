package com.webdev.productsystem.Shared.Infrastruture.RabbitMQ.Serializable;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webdev.productsystem.Shared.Domain.Bus.Event.DomainEvent;
import com.webdev.productsystem.Shared.Infrastruture.RabbitMQ.DomainEventsInformation;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.HashMap;

public class DomainEventJsonDeserializer {

    private final DomainEventsInformation information;

    public DomainEventJsonDeserializer(DomainEventsInformation information){
        this.information = information;
    }


    public DomainEvent deserialize(String body) throws Exception{
        HashMap<String, Serializable> eventData = this.jsonDecode(body);
        HashMap<String, Serializable> data = (HashMap<String, Serializable>) eventData.get("data");
        HashMap<String, Serializable> attributes = (HashMap<String, Serializable>) eventData.get("attributes");

        Class<? extends DomainEvent> domainEventClass = information.getDomainEvent( (String) data.get("type") );
        DomainEvent nullInstance = domainEventClass.getConstructor().newInstance();

        Method fromPrimitiveMethod = domainEventClass.getMethod("fromPrimitives", String.class, HashMap.class, String.class, String.class);
        Object domainEvent = fromPrimitiveMethod.invoke(nullInstance, (String) attributes.get("id"),attributes,
                (String) attributes.get("id"), attributes.get("occured_on"));

        return (DomainEvent) domainEvent;
    }


    public HashMap<String, Serializable> jsonDecode(String body){
        try{
            return new ObjectMapper().readValue(body, HashMap.class);
        }
        catch(Exception e){
            return null;
        }

    }
}
