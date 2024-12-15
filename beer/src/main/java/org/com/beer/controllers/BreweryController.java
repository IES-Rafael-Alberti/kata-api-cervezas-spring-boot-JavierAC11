package org.com.beer.controllers;

import org.com.beer.entities.Brewery;
import org.com.beer.repository.BreweryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/breweries")
public class BreweryController {
    private final BreweryRepository breweryRepository;

    @Autowired
    public BreweryController (BreweryRepository breweryRepository) {
        this.breweryRepository = breweryRepository;
    }

    @GetMapping()
    public List<Brewery> listarBreweries(){
        return breweryRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Brewery> obtenerBrewery(@PathVariable Long id){
        return breweryRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
