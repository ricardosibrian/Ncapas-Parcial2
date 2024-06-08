package com.example.prepractica.services;

import com.example.prepractica.domain.dtos.Historial.CreateHistorialDTO;
import com.example.prepractica.domain.entities.User;

public interface HistorialService {
    void CreateHistorial(User user, CreateHistorialDTO info);
    User findUserByUsernameOrEmail(String username, String email);
    User findUserByIdentifier(String identifier);
}
