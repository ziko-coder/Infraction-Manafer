package com.example.immatriculationservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Collection;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor  @Builder
public class Proprietaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate birthDate;
    private String email;
    @OneToMany(mappedBy = "proprietaire", fetch = FetchType.EAGER)
    @JsonIgnore
    private Collection<Vehicule> vehicules;
    //
    @Override
    public String toString() {
        return "Proprietaire{" +
                "id=" + id +
                ", nom='" + name  + '\'' +
                ", email='" + email + '\'' +
                ", date de naissance ='" + birthDate + '\'' +
                // Exclude Veicule association from toString()
                ", vehicule='" + vehicules + '\'' +
                '}';
    }


}
