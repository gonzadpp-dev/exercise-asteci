package com.gonzadpp.exerciseasteci.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.gonzadpp.exerciseasteci.client.PetStoreClient;
import com.gonzadpp.exerciseasteci.dto.PetRequest;
import com.gonzadpp.exerciseasteci.dto.PetResponse;
import com.gonzadpp.exerciseasteci.dto.PetTransactionalResponse;
import com.gonzadpp.exerciseasteci.dto.petstore.PetStoreResponse;

@Service
public class PetServiceImpl implements PetService{

    private final PetStoreClient petStoreClient;

    public PetServiceImpl(PetStoreClient petStoreClient){
        this.petStoreClient = petStoreClient;
    }

    @Override
    public PetResponse getPetById(Integer petId) {
        PetStoreResponse petStoreResponse = petStoreClient.getPetById(petId);

        return new PetResponse(
            petStoreResponse.id(), 
            petStoreResponse.name(), 
            petStoreResponse.status());
    }

    @Override
    public PetTransactionalResponse addPet(PetRequest request) {

        PetStoreResponse response = petStoreClient.addPet(request);

        Boolean status = "available".equalsIgnoreCase(response.status());

        return new PetTransactionalResponse(
            UUID.randomUUID(), 
            LocalDateTime.now(),
            status, 
            response.name());
    }

}
