package com.example.radarservice.repositories;

import com.example.radarservice.entities.Radar;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RadarRepository extends JpaRepository<Radar, Long> {
    Page<Radar> findByNameContains(String keyword, Pageable pageable);
    //Optional<Radar> findByNumero(String numero);
}