package com.webdev.productsystem.Tours.Tour.Infrastructure.Listeners;

import com.webdev.productsystem.Tours.Tour.Application.AddTouristicLocation.TourAddTouristicLocation;
import com.webdev.productsystem.Tours.TouristicLocation.Domain.DomainEvents.TouristicLocationCreatedDomainEvent;

public class AddTouristicLocationOnTouristicLocationCreated {
    private TourAddTouristicLocation adder;

    public AddTouristicLocationOnTouristicLocationCreated(TourAddTouristicLocation adder) {
        this.adder = adder;
    }

    public void on(TouristicLocationCreatedDomainEvent event) {
        System.out.println("🟢 EVENT: " + event.getName());
        this.adder.execute(
                event.getId(),
                event.getName(),
                event.getTourId()
        );
    }
}
