package com.webdev.productsystem.Tours.City.Domain;

import java.util.HashMap;

import com.webdev.productsystem.Tours.City.Domain.ValueObjects.CityCountry;
import com.webdev.productsystem.Tours.City.Domain.ValueObjects.CityId;
import com.webdev.productsystem.Tours.City.Domain.ValueObjects.CityName;

public class City {
    
    public CityId cityId;
    public CityName cityName;
    public CityCountry cityCountry;

    public City(CityId cityId, CityName cityName, CityCountry cityCountry) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.cityCountry = cityCountry;
    }

    public static City create(CityId cityId, CityName cityName, CityCountry cityCountry){
        City city = new City(cityId, cityName, cityCountry);
        return city;
    }

    public HashMap<String, Object> data(){
        return new HashMap<>(){{
            put("cityId",cityId.value());
            put("cityName",cityName.value());
            put("cityCountry",cityCountry.value());
        }};
    }

    public void updateCityName(CityName name){
        this.cityName = name;
    }

    public void updateCityCountry(CityCountry country){
        this.cityCountry = country;
    }

}
