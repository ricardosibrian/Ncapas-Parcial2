package com.example.prepractica.domain.dtos.CitaMedica;

import com.example.prepractica.domain.entities.CitaMedica;
import com.example.prepractica.domain.entities.Prescripcion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObtainAppointmentsDTO {

    private List<CitaMedica> citaMedicas;

    private List<Prescripcion> prescripciones;
}
