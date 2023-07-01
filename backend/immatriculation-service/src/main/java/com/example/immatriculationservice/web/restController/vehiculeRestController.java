package com.example.immatriculationservice.web.restController;

import com.example.immatriculationservice.entities.OwnerDetails;
import com.example.immatriculationservice.entities.Proprietaire;
import com.example.immatriculationservice.entities.Vehicule;
import com.example.immatriculationservice.repositories.ProprietaireRepository;
import com.example.immatriculationservice.repositories.VehiculeRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class vehiculeRestController {
    private VehiculeRepository vehiculeRepo;
    private ProprietaireRepository proprietaireRepository;

    @GetMapping("/vehicules")
    public List<Vehicule> getAllVehicules() {
        return vehiculeRepo.findAll();
    }

    @GetMapping("/vehicules/{id}")
    public Vehicule getVehiculeById(@PathVariable Long id) {
        return vehiculeRepo.findById(id).orElse(null);
    }


    @GetMapping("/vehicules/matricules/{matricule}") // hadiii
    public ResponseEntity<Vehicule> findByMatricule(@PathVariable String matricule){
    Vehicule vehicule = vehiculeRepo.findByMatricule(matricule);
        if (vehicule != null) {
            return ResponseEntity.ok(vehicule);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/vehicules")
    public Vehicule saveVehicule(@RequestBody Vehicule vehicule) {
        return vehiculeRepo.save(vehicule);
    }

    @PutMapping("/vehicules/{id}")
    public Vehicule updateVehicule(@RequestBody Vehicule vehicule, @PathVariable Long id) {
        vehicule.setId(id);
        return vehiculeRepo.save(vehicule);
    }

    @DeleteMapping("/vehicules/{id}")
    public void deleteVehicule(@PathVariable Long id) {
        vehiculeRepo.deleteById(id);
    }

    @GetMapping("proprietaires/{id}/vehicules")
    public ResponseEntity<List<Vehicule>> getVehiculesByProprietaireId(@PathVariable Long id) {
        Proprietaire proprietaire = proprietaireRepository.findById(id).orElse(null);
        if (proprietaire != null) {
            List<Vehicule> vehicules = (List<Vehicule>) vehiculeRepo.getVehiculeByProprietaireId(proprietaire.getId());
            return ResponseEntity.ok(vehicules);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Get vehicle by regestration number
    @GetMapping("/vehicules/{rn}")
    public Vehicule getByRegistrationNumber(@PathVariable String rn){
        return vehiculeRepo.findVehicleByRegistrationNumber(rn);
    }

    // Get number of all vehicles
    @GetMapping("/vehicules/count")
    public Long getVehiclesCount() {
        return vehiculeRepo.count();
    }

    // Get all vehicle pages
    @GetMapping("/vehicules/pageVehicule")
    public Page<Vehicule> getPageVehicle(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "5") int size) {

        Pageable pageable = PageRequest.of(page, size);
        return vehiculeRepo.findAll(pageable);
    }

    // Search vehicles pages by regestration number containing
    //              /vehicules/PageVehiculeName/
    @GetMapping("/vehicules/pageVehiculeName/{keyword}") // same as registration number
    public Page<Vehicule> getVehiclesByName(@PathVariable String keyword,
                                           @RequestParam(value = "page", defaultValue = "0") int page,
                                           @RequestParam(value = "size", defaultValue = "5") int size) {

        Pageable pageable = PageRequest.of(page, size);

        if (keyword.equals(null)) return vehiculeRepo.findAll(pageable);
        return vehiculeRepo.findByRegistrationNumberContaining(keyword, pageable);
    }

    @GetMapping("/proprietaires/registration/{registrationNumber}")
    public ResponseEntity<Long> getOwnerIdByRegistrationNumber(@PathVariable String registrationNumber) {
        Vehicule vehicule = vehiculeRepo.findVehicleByRegistrationNumber(registrationNumber);
        if (vehicule != null) {
            Long ownerId = vehicule.getProprietaire().getId();
            return ResponseEntity.ok(ownerId);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
