package com.example.immatriculationservice.web.restController;

import com.example.immatriculationservice.entities.Proprietaire;
import com.example.immatriculationservice.entities.Vehicule;
import com.example.immatriculationservice.repositories.VehiculeRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.immatriculationservice.repositories.ProprietaireRepository;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class proprietaireRestController {
    private ProprietaireRepository proprietaireRepo;


    @GetMapping("/proprietaires")
    public List<Proprietaire> getAllProprietaires() {
        return proprietaireRepo.findAll();
    }

    @GetMapping("/proprietaires/{id}")
    public Proprietaire getProprietaireById(@PathVariable Long id) {
        return proprietaireRepo.findById(id).orElse(null);
    }

    @PostMapping("/proprietaires")
    public Proprietaire saveProprietaire(@RequestBody Proprietaire proprietaire) {
        proprietaireRepo.save(proprietaire);
        return proprietaire;
    }

    @PutMapping("/proprietaires/{id}")
    public Proprietaire updateProprietaire(@RequestBody Proprietaire proprietaire, @PathVariable Long id) {
        proprietaire.setId(id);
        return proprietaireRepo.save(proprietaire);
    }

    @DeleteMapping("/proprietaires/{id}")
    public void deleteProprietaire(@PathVariable Long id) {
        proprietaireRepo.deleteById(id);
    }



}
