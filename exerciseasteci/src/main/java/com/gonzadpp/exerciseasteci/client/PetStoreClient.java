package com.gonzadpp.exerciseasteci.client;

import org.springframework.http.MediaType;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import com.gonzadpp.exerciseasteci.dto.PetRequest;
import com.gonzadpp.exerciseasteci.dto.petstore.PetStoreResponse;

@Component
public class PetStoreClient {
    private final RestClient restClient;

    public PetStoreClient(RestClient.Builder restClient){
        this.restClient = restClient
            .baseUrl("https://petstore.swagger.io/v2")
            .build();
    }

    public PetStoreResponse getPetById(Integer petId){
        return restClient.get()
            .uri("/pet/{petId}", petId)
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .body(PetStoreResponse.class);
    }

    @SuppressWarnings("null")
    public PetStoreResponse addPet(@NonNull PetRequest request){
        return restClient.post()
            .uri("/pet")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .body(request)
            .retrieve()
            .body(PetStoreResponse.class);
    }
    
}
