package com.gonzadpp.exerciseasteci.service;

import org.springframework.lang.NonNull;

import com.gonzadpp.exerciseasteci.dto.PetRequest;
import com.gonzadpp.exerciseasteci.dto.PetResponse;
import com.gonzadpp.exerciseasteci.dto.PetTransactionalResponse;

public interface PetService {

    PetResponse getPetById(Integer petId);

    PetTransactionalResponse addPet(@NonNull PetRequest request);
    
}
