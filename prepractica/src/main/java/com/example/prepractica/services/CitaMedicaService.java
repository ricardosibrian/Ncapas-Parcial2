package com.example.prepractica.services;

import com.example.prepractica.domain.dtos.CitaMedica.CreateCitaMedicaDTO;
import com.example.prepractica.domain.dtos.CitaMedica.ResponseAppointmentDTO;
import com.example.prepractica.domain.dtos.User.RegisterDTO;
import com.example.prepractica.domain.entities.CitaMedica;
import com.example.prepractica.domain.entities.User;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface CitaMedicaService {

    void CreateCitaMedica(CreateCitaMedicaDTO info, User user);

    CitaMedica GetCitaMedicaByUUID(UUID id);

    List<CitaMedica> getAllCitasMedicas();
}