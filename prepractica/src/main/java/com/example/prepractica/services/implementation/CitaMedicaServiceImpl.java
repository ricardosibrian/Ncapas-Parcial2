package com.example.prepractica.services.implementation;

import com.example.prepractica.domain.dtos.CitaMedica.CreateCitaMedicaDTO;
import com.example.prepractica.domain.dtos.CitaMedica.ObtainAppointmentsDTO;
import com.example.prepractica.domain.dtos.CitaMedica.ResponseAppointmentDTO;
import com.example.prepractica.domain.entities.CitaMedica;
import com.example.prepractica.domain.entities.Rol;
import com.example.prepractica.domain.entities.User;
import com.example.prepractica.repositories.CitaMedicaRepository;
import com.example.prepractica.repositories.UserRepository;
import com.example.prepractica.services.CitaMedicaService;
import com.example.prepractica.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CitaMedicaServiceImpl implements CitaMedicaService {

    private final CitaMedicaRepository citaMedicaRepository;

    private final UserService userService;
    private final UserRepository userRepository;

    public CitaMedicaServiceImpl(CitaMedicaRepository citaMedicaRepository, UserService userService, UserRepository userRepository) {
        this.citaMedicaRepository = citaMedicaRepository;
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @Override
    public void CreateCitaMedica(CreateCitaMedicaDTO info, User user) {

        CitaMedica citaMedica = new CitaMedica();

        citaMedica.setApplicationDate(Date.from(Instant.now()));
        citaMedica.setReason(info.getReason());
        citaMedica.setState("Pendiente de aprobacion");
        citaMedica.setUser(user);

        citaMedicaRepository.save(citaMedica);
    }

    @Override
    public CitaMedica GetCitaMedicaByUUID(UUID id) {
        return citaMedicaRepository
                .findById(id)
                .orElse(null);
    }

    @Override
    public List<CitaMedica> getAllCitasMedicas() {
        return citaMedicaRepository.findAll();
    }

    @Override
    public List<ObtainAppointmentsDTO> getByUser(User user) {
        return userRepository
                .findAll()
                .stream()
                .map(user1 -> new ObtainAppointmentsDTO(user1.getCitas(), null))
                .collect(Collectors.toList());
    }
}