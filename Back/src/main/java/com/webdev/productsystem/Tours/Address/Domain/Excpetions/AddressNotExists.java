package com.webdev.productsystem.Tours.Address.Domain.Excpetions;

public class AddressNotExists extends RuntimeException{
    public AddressNotExists(String message) {
        super(message);
    }
}
