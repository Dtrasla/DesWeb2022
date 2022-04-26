package com.webdev.productsystem.Tours.Tour.Domain.ValueObjects;

import java.util.List;

import com.webdev.productsystem.Shared.Domain.Aggregate.ListValueObject;

public class TourCity extends ListValueObject{
    /*private String id;
    private String name;
    private String country;*/
    private TourCity(){}

    public TourCity(List<String> cities){
        validate(cities);
        this.value=cities;
    }

    public void validate(List<String> cities){

        

    }

    /*public HashMap<String, Object> data() {
        return new HashMap<>() {{
            put("id", id);
            put("zipCode", name);
            put("data", country);
        }};
    }*/
}
