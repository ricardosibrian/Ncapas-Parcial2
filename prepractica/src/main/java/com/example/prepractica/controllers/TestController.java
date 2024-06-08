package com.example.prepractica.controllers;

import com.example.prepractica.domain.dtos.GeneralResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    @PostMapping("/appointment/approve")
    public ResponseEntity<GeneralResponse> approve (){

        return GeneralResponse.getResponse(HttpStatus.OK, "Tienes permiso");
    }

    @GetMapping("/appointment/owner")
    public ResponseEntity<GeneralResponse> owner (){

        return GeneralResponse.getResponse(HttpStatus.OK, "Tienes permiso");
    }

    @GetMapping("/clinic/schedule")
    public ResponseEntity<GeneralResponse> schedule (){

        return GeneralResponse.getResponse(HttpStatus.OK, "Tienes permiso");
    }

    @GetMapping("/clinic/prescriptions/{userId}")
    public ResponseEntity<GeneralResponse> approve (@PathVariable String userId){

        return GeneralResponse.getResponse(HttpStatus.OK, "Tienes permiso");
    }

    @PostMapping("/config/user-role")
    public ResponseEntity<GeneralResponse> userRole (){

        return GeneralResponse.getResponse(HttpStatus.OK, "Tienes permiso");
    }

    @PostMapping("/user/record")
    public ResponseEntity<GeneralResponse> record1 (){

        return GeneralResponse.getResponse(HttpStatus.OK, "Tienes permiso");
    }

    @GetMapping("/user/record")
    public ResponseEntity<GeneralResponse> record2 (){

        return GeneralResponse.getResponse(HttpStatus.OK, "Tienes permiso");
    }

    @PostMapping("/clinic/prescriptions")
    public ResponseEntity<GeneralResponse> presCriptions (){

        return GeneralResponse.getResponse(HttpStatus.OK, "Tienes permiso");
    }

    @PostMapping("/appointment/finish")
    public ResponseEntity<GeneralResponse> finish (){

        return GeneralResponse.getResponse(HttpStatus.OK, "Tienes permiso");
    }
}
