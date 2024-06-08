package com.example.prepractica.repositories;

import com.example.prepractica.domain.entities.Prescripcion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PrescripcionRepository extends JpaRepository<Prescripcion, UUID> {

}
