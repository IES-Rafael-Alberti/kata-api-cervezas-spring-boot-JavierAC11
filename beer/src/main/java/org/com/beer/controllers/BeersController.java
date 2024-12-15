package org.com.beer.controllers;

import org.com.beer.entities.Beers;
import org.com.beer.repository.BeersRepository;
import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/beers")
public class BeersController {
    private final BeersRepository beersRepository;

    @Autowired
    public BeersController(BeersRepository beersRepository) {
        this.beersRepository = beersRepository;
    }


    @GetMapping
    public List<Beers> listarBeers() {
        return beersRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Beers> obtenerBeer(@PathVariable Long id) {
        return beersRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Beers> eliminarCerveza(@PathVariable(required = true) Long id) {
        if (id == null || !beersRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        beersRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Beers> crearBeer(@RequestBody Beers beer) {
        return ResponseEntity.ok(this.beersRepository.save(beer));
    }
}