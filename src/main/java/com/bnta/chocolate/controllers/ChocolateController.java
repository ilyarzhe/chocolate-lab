package com.bnta.chocolate.controllers;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/chocolates")
public class ChocolateController {
    @Autowired
    ChocolateRepository chocolateRepository;

    @GetMapping
    public List<Chocolate> getAllChocolates(){
        return chocolateRepository.findAll();
    }
    @GetMapping(path ="/{id}")
    public Chocolate getChocolateById(@PathVariable long id){
        return chocolateRepository.findById(id).get();
    }

    @PostMapping
    public ResponseEntity<Chocolate> addNewChocolate(@RequestBody Chocolate chocolate) {
        chocolateRepository.save(chocolate);
        return new ResponseEntity<>(chocolate, HttpStatus.OK);
    }
}
