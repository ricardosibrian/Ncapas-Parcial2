package com.example.prepractica.services.implementation;

import com.example.prepractica.domain.dtos.CitaMedica.CreateCitaMedicaDTO;
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
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CitaMedicaServiceImpl implements CitaMedicaService {

    private final CitaMedicaRepository citaMedicaRepository;

    private final UserService userService;

    public CitaMedicaServiceImpl(CitaMedicaRepository citaMedicaRepository, UserService userService) {
        this.citaMedicaRepository = citaMedicaRepository;
        this.userService = userService;
    }

    @Override
    public void CreateCitaMedica(CreateCitaMedicaDTO info, User user) {

        CitaMedica citaMedica = new CitaMedica();
        citaMedica.setUser(user);
        citaMedica.setTitulo(info.getTitulo());
        citaMedica.setDescripcion(info.getDescripcion());

        citaMedicaRepository.save(citaMedica);
    }

    @Override
    public List<CitaMedica> findByUserAndTittle(User user, String tittle) {
        return citaMedicaRepository
                .findAll()
                .stream()
                .filter(citaMedica -> citaMedica.getUser().getEmail().equals(user.getEmail()))
                .filter(citaMedica -> citaMedica.getTitulo().equals(tittle))
                .collect(Collectors.toList());
    }

    @Override
    public CitaMedica GetCitaMedicaByUUID(UUID id) {
        return citaMedicaRepository
                .findById(id)
                .orElse(null);
    }

    @Override
    public Date validFechaHoraInicio(String fechaHoraInicio) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(fechaHoraInicio);
        } catch (ParseException ex) {
            return null;
        }
    }

    @Override
    public List<CitaMedica> getAllCitasMedicas() {
        return citaMedicaRepository.findAll();
    }

    @Override
    public void ResponseAppointment(List<CitaMedica> appointments, ResponseAppointmentDTO info, User user) {

        appointments.forEach(appointment -> {
            appointment.setState(info.getState());
            citaMedicaRepository.save(appointment);
        });

        if (info.getState().equals("Accepted")) {
            Rol newrol = userService.findRoleByIdentifier("AA14");

            userService.agregarRol(user, newrol);
        }
    }
}
