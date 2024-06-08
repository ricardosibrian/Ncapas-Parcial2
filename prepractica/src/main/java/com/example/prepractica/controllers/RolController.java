package com.example.prepractica.controllers;

import com.example.prepractica.domain.dtos.GeneralResponse;
import com.example.prepractica.domain.entities.Rol;
import com.example.prepractica.domain.dtos.User.AddRolDTO;
import com.example.prepractica.domain.entities.User;
import com.example.prepractica.services.RolService;
import com.example.prepractica.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class RolController {

    @Autowired
    UserService userService;

    @Autowired
    RolService roleService;

    @PostMapping("/user-role")
    public ResponseEntity<GeneralResponse> addRol (@RequestBody @Valid AddRolDTO info){

        // Obtener el usuario de la base de datos
        User user = userService.findUserByIdentifier(info.getIdentifier());
        if (user != null) {

            // Obtener el rol de la base de datos
            Rol rol = userService.findRoleByIdentifier(info.getRolId());
            if (rol != null) {
                userService.agregarRol(user, rol);
            } else {
                // Manejar el caso en que no se encuentra el rol en la base de datos
                return GeneralResponse.getResponse(HttpStatus.NOT_FOUND, "Rol not found");
            }
        } else {
            // Manejar el caso en que no se encuentra el usuario en la base de datos
            return GeneralResponse.getResponse(HttpStatus.NOT_FOUND, "User not found");
        }

        return GeneralResponse.getResponse(HttpStatus.OK, "Add rol successfully");
    }
}
