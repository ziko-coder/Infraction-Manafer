package com.example.radarservice.feignClients;


import com.example.radarservice.models.Proprietaire;
import com.example.radarservice.models.Vehicule;
import jakarta.ws.rs.Path;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "IMMATRICULATION-SERVICE", url = "http://localhost:8080")
public interface ImmatriculationClient {
    @GetMapping("/proprietaires/{id}")
    Proprietaire getProprietaire(@PathVariable Long id);

    @GetMapping("/vehicules/matricules/{matricule}")
    Vehicule getVehiculeByMatricule(@PathVariable String matricule);

}
