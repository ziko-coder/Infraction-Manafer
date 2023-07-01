package com.example.radarservice.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String registrationNumber;
    private String brand;
    private String model;
    private int fiscalPower;
    @ManyToOne
    @JsonIgnore
    Proprietaire proprietaire;


    //
    @Override
    public String toString() {
        return "Vehicule{" +
                "id=" + id +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", fiscalPower=" + fiscalPower +
                // Exclude Proprietaire association from toString()
                '}';
    }
}

