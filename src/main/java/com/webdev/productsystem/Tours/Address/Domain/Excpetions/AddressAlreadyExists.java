package com.webdev.productsystem.Tours.Address.Domain.Excpetions;

public class AddressAlreadyExists extends RuntimeException{
    public AddressAlreadyExists(String message) {
        super(message);
    }
}
