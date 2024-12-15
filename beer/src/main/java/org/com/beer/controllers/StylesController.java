package org.com.beer.controllers;

import org.com.beer.entities.Style;
import org.com.beer.repository.StyleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/styles")
public class StylesController {

    private final StyleRepository styleRepository;

    @Autowired
    public StylesController (StyleRepository styleRepository) {
        this.styleRepository = styleRepository;
    }

    @GetMapping
    public List<Style> listarStyles(){
        return styleRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Style> obtenerStyle(@PathVariable Long id){
        return styleRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
