package com.example.radarservice.models;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
@Builder
public class Infraction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private  Long numeroRadar;
    private Double vitesseMaxRadar;
    private String matriculeVehicule;
    private double vitesseVehicule;
    private double montantFraction;



}
