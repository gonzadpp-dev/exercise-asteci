package com.gonzadpp.exerciseasteci.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record PetTransactionalResponse(
    UUID transactionId,
    LocalDateTime dateCreated,
    Boolean status,
    String name
) {
    
}
