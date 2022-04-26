package com.webdev.productsystem.Users.Phone.Application.All;

import com.webdev.productsystem.Tours.Hotel.Domain.Hotel;
import com.webdev.productsystem.Users.Phone.Domain.Phone;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class PhoneFindAllResponse {
    private List<Phone> phones;

    public PhoneFindAllResponse(List<Phone> phones) {
        this.phones = phones;
    }

    public List<HashMap<String, Object>> response() {
        return phones.stream().map(phone -> phone.data()).collect(Collectors.toList());
    }
}
