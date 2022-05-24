package com.webdev.productsystem.Tours.TouristicLocation.Domain.Exceptions;

public class TouristicLocationNotExists extends RuntimeException{
    public TouristicLocationNotExists(String message) { super(message); }
}