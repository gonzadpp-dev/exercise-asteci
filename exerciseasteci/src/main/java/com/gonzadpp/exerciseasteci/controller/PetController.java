package com.gonzadpp.exerciseasteci.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gonzadpp.exerciseasteci.dto.PetRequest;
import com.gonzadpp.exerciseasteci.dto.PetResponse;
import com.gonzadpp.exerciseasteci.dto.PetTransactionalResponse;
import com.gonzadpp.exerciseasteci.service.PetService;

@RestController
@RequestMapping(value = "/api")
public class PetController {
    
    private final PetService petService;

    public PetController(PetService petService){
        this.petService = petService;
    }

    @GetMapping("/pet/{petId}")
    public ResponseEntity<PetResponse> getPetById(@PathVariable Integer petId){
        return ResponseEntity.ok(petService.getPetById(petId));
    }

    @PostMapping("/pet")
    public ResponseEntity<PetTransactionalResponse> addPet(@RequestBody PetRequest request){
        return ResponseEntity.ok(petService.addPet(request));
    }

}
