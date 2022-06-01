package com.webdev.productsystem.Tours.City.Application.Delete;

import java.util.Optional;

import com.webdev.productsystem.Tours.City.Domain.City;
import com.webdev.productsystem.Tours.City.Domain.Exceptions.CityNotFound;
import com.webdev.productsystem.Tours.City.Domain.Ports.CityRepository;
import com.webdev.productsystem.Tours.City.Domain.ValueObjects.CityId;

public class DeleteCity {
    
    private CityRepository repository;

    //Busqueda del ticket

    public DeleteCity(CityRepository repository){
        this.repository= repository;
    }

    public void execute(String cityId){

        //Find the estate
        Optional<City> tourOptional = repository.find(new CityId(cityId));
        if(tourOptional.isEmpty()){

            throw new CityNotFound("No pudimos encontrar un Tiquete con el numero" + cityId + "por favor asegurese de ingresarlo correctamente");

        }else{

            City city = tourOptional.get();
            repository.delete(city);
            System.out.print("Tiquete borrado exitosamente");

        }

    }

}
