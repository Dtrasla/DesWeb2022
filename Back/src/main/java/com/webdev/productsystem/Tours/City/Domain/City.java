package com.webdev.productsystem.Tours.City.Domain;

import java.util.HashMap;

import com.webdev.productsystem.Tours.Address.Domain.ValueObjects.AddressZipCode;
import com.webdev.productsystem.Tours.City.Domain.ValueObjects.CityCountry;
import com.webdev.productsystem.Tours.City.Domain.ValueObjects.CityId;
import com.webdev.productsystem.Tours.City.Domain.ValueObjects.CityName;
import com.webdev.productsystem.Tours.City.Domain.ValueObjects.TouristicLocationId;

public class City {
    
    public CityId cityId;
    public CityName cityName;
    public CityCountry cityCountry;
    public TouristicLocationId touristicLocationId;

    public City() {
    }

    public City(CityId cityId, CityName cityName, CityCountry cityCountry, TouristicLocationId touristicLocationId) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.cityCountry = cityCountry;
        this.touristicLocationId = touristicLocationId;
    }

    public static City create(CityId cityId, CityName cityName, CityCountry cityCountry, TouristicLocationId touristicLocationId){
        City city = new City(cityId, cityName, cityCountry, touristicLocationId);
        return city;
    }

    public HashMap<String, Object> data(){
        return new HashMap<>(){{
            put("cityId",cityId.value());
            put("cityName",cityName.value());
            put("cityCountry",cityCountry.value());
            put("touristicLocationId",touristicLocationId.value());
        }};
    }

    public void updateCityName(CityName cityName) {
        this.cityName = cityName;
    }
    public void updateCityCountry(CityCountry cityCountry) {
        this.cityCountry = cityCountry;
    }
    public void updateTouristicLocationId(TouristicLocationId touristicLocationId) {
        this.touristicLocationId = touristicLocationId;
    }

}
