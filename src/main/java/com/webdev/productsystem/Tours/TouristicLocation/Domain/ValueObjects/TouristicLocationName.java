package com.webdev.productsystem.Tours.TouristicLocation.Domain.ValueObjects;

import com.webdev.productsystem.Shared.Domain.Aggregate.StringValueObject;

import com.webdev.productsystem.Tours.TouristicLocation.Domain.Exceptions.TouristicLocationNameInvalidLength;

public class TouristicLocationName extends StringValueObject {
    private TouristicLocationName() {}

    public TouristicLocationName(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        validateLength(value);
    }

    private void validateLength(String value) {
        if(value.length() < 5 || value.length() > 25)
            throw new TouristicLocationNameInvalidLength("Touristic location name must be between 5 and 25 characters");
    }
}
