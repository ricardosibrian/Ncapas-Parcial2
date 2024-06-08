package com.example.prepractica.repositories;

import com.example.prepractica.domain.entities.Historial;
import com.example.prepractica.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface HistorialRepository extends JpaRepository<Historial, UUID> {

}