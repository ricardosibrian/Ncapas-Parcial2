package com.example.prepractica.domain.dtos.Historial;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateHistorialDTO {

    @NotBlank
    private String reason;

    @NotNull
    private String identifier;
}