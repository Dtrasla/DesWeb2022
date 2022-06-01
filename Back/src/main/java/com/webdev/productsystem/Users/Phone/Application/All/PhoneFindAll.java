package com.webdev.productsystem.Users.Phone.Application.All;

import com.webdev.productsystem.Tours.Hotel.Domain.Hotel;
import com.webdev.productsystem.Tours.Hotel.Domain.Ports.HotelRepository;
import com.webdev.productsystem.Users.Phone.Domain.Phone;
import com.webdev.productsystem.Users.Phone.Domain.Ports.PhoneRepository;

import java.util.ArrayList;
import java.util.List;

public class PhoneFindAll {
    private PhoneRepository repository;

    public PhoneFindAll(PhoneRepository repository) {
        this.repository = repository;
    }

    public List<Phone> execute() {
        List<Phone> result = new ArrayList<Phone>();
        if (repository.all().isPresent())
            result = repository.all().get();
        return result;
    }
}
