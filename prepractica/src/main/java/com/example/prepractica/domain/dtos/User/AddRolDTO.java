package com.example.prepractica.domain.dtos.User;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.UUID;

@Data
public class AddRolDTO {
    @NotBlank
    private String identifier; // Puede ser username o email

    @NotBlank
    private String rolId;
}
