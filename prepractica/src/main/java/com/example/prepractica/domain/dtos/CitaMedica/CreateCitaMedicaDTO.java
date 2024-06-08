package com.example.prepractica.domain.dtos.CitaMedica;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Date;

@Data
public class CreateCitaMedicaDTO {

    private String reason;
}