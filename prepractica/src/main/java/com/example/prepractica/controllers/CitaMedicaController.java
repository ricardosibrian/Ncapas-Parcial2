package com.example.prepractica.controllers;

import com.example.prepractica.domain.dtos.CitaMedica.CreateCitaMedicaDTO;
import com.example.prepractica.domain.dtos.CitaMedica.ResponseAppointmentDTO;
import com.example.prepractica.domain.dtos.GeneralResponse;
import com.example.prepractica.domain.dtos.User.RegisterDTO;
import com.example.prepractica.domain.entities.CitaMedica;
import com.example.prepractica.domain.entities.User;
import com.example.prepractica.services.CitaMedicaService;
import com.example.prepractica.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/appointment")
public class CitaMedicaController {

    private final CitaMedicaService citaMedicaService;

    private final UserService userService;

    public CitaMedicaController(CitaMedicaService citaMedicaService, UserService userService) {
        this.citaMedicaService = citaMedicaService;
        this.userService = userService;
    }

    @PostMapping("/request")
    public ResponseEntity<GeneralResponse> createCitaMedica (@RequestBody @Valid CreateCitaMedicaDTO info){

        User user = userService.findUserAuthenticated();

        citaMedicaService.CreateCitaMedica(info, user);

        return GeneralResponse.getResponse(HttpStatus.OK, "Create Cita Medica successful");
    }

    @GetMapping("/getAll")
    public ResponseEntity<GeneralResponse> getAllCitasMedicas (){

        List<CitaMedica> citaMedica = citaMedicaService.getAllCitasMedicas();

        return GeneralResponse.getResponse(HttpStatus.OK, citaMedica);
    }


}