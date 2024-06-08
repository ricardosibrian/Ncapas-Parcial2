package com.example.prepractica.services;

import com.example.prepractica.domain.dtos.Rol.CreateRolDTO;
import com.example.prepractica.domain.entities.Rol;

public interface RolService {
    void createRol(CreateRolDTO info);

}
