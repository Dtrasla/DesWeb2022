package com.webdev.productsystem.Tours.Address.Application.All;

import com.webdev.productsystem.Tours.Address.Domain.Address;
import com.webdev.productsystem.Tours.Hotel.Domain.Hotel;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class AddressFindAllResponse {
    private List<Address> addresses;

    public AddressFindAllResponse(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<HashMap<String, Object>> response() {
        return addresses.stream().map(hotel -> hotel.data()).collect(Collectors.toList());
    }
}
