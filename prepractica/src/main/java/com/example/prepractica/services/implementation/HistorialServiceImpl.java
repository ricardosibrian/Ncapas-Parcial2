package com.example.prepractica.services.implementation;

import com.example.prepractica.domain.dtos.Historial.CreateHistorialDTO;
import com.example.prepractica.domain.entities.Historial;
import com.example.prepractica.domain.entities.User;
import com.example.prepractica.repositories.HistorialRepository;
import com.example.prepractica.repositories.UserRepository;
import com.example.prepractica.services.HistorialService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;

@Service
@Slf4j
public class HistorialServiceImpl implements HistorialService {

    private final HistorialRepository historialRepository;
    private final UserRepository userRepository;

    public HistorialServiceImpl(HistorialRepository historialRepository, UserRepository userRepository) {
        this.historialRepository = historialRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void CreateHistorial(User user, CreateHistorialDTO info) {

        Historial historial = new Historial();
        historial.setFecha(Date.from(Instant.now()));
        historial.setReason(info.getReason());
        historial.setUser(user);
        historialRepository.save(historial);
    }

    @Override
    public User findUserByIdentifier(String identifier) {
        return this.findUserByUsernameOrEmail(identifier, identifier);
    }

    @Override
    public User findUserByUsernameOrEmail(String username, String email) {
        return userRepository
                .findByUsernameOrEmail(username, email)
                .orElse(null);
    }
}