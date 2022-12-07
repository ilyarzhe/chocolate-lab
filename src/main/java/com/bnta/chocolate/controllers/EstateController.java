package com.bnta.chocolate.controllers;

import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.EstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/estates")
public class EstateController {
    @Autowired
    EstateRepository estateRepository;

    @GetMapping
    public List<Estate> getAllEstates(){
        return estateRepository.findAll();
    }
    @GetMapping(path = "/{id}")
    public Estate getEstateById(@PathVariable long id){
        return estateRepository.findById(id).get();
    }

    @PostMapping
    public ResponseEntity<Estate> addNewEstate(@RequestBody Estate estate) {
        estateRepository.save(estate);
        return new ResponseEntity<>(estate, HttpStatus.OK);
    }

}
