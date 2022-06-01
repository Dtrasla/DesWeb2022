package com.webdev.productsystem.Tours.TouristicLocation.Domain.Exceptions;

public class TouristicLocationAlreadyExists  extends RuntimeException{
    public TouristicLocationAlreadyExists(String message) { super(message); }
}
