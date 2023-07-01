package com.example.radarservice.web;

import com.example.radarservice.entities.Radar;
import com.example.radarservice.feignClients.ImmatriculationClient;
import com.example.radarservice.feignClients.InfractionClient;
import com.example.radarservice.models.Infraction;
import com.example.radarservice.models.Proprietaire;
import com.example.radarservice.models.Vehicule;
import com.example.radarservice.repositories.RadarRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.Date;
import java.util.List;


@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class RadarRestController {
    private RadarRepository radarRepository;
    private ImmatriculationClient immatriculationClient;
    private InfractionClient infractionClient;


    @GetMapping("/radars")
    public List<Radar> getAllRadars(){
        return radarRepository.findAll();
    }

    @GetMapping("/radars/{id}")
    public Radar getRadarById(@PathVariable Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Radar ID cannot be null");
        }

        return radarRepository.findById(id).orElse(null);
    }

    //Insert method :
    @PostMapping("/radars")
    public Radar saveRadar(@RequestBody Radar radar){
        System.out.println("Inserting Radar : "+radar.toString());
        return radarRepository.save(radar);
    }

    //Update method :
    @PutMapping("/radars/{id}")
    public Radar updateRadar(@RequestBody Radar radar, @PathVariable long id){
        radar.setId(id); //l'objet radar chargé dans la requet est déja modifié il faut juste l'inserer dans bdd.
        return radarRepository.save(radar);
    }

    //Delete method :
    @DeleteMapping("/radars/{id}")
    public void deleteRadar(@PathVariable long id){
        radarRepository.deleteById(id);
        System.out.println(">> [Deleting Radar]: Radar [ID = "+id+" ] has been deleted successfuly !");
    }


    @PostMapping("radars/generateInfraction")
    public Infraction generateInfraction(@RequestParam String matricule, @RequestParam Long id, @RequestParam Double vitesseVehicule){
        Radar radar=radarRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Radar with id: " + id + "not found"));;
        Vehicule vehicule=immatriculationClient.getVehiculeByMatricule(matricule);
        Proprietaire proprietaire=vehicule.getProprietaire();
        Infraction infraction=new Infraction();
        infraction.setDate(new Date());
        infraction.setNumeroRadar(radar.getId());
        infraction.setMatriculeVehicule(matricule);
        infraction.setVitesseVehicule(vitesseVehicule);
        infraction.setVitesseMaxRadar(radar.getMaxSpeed());
        if (infraction.getVitesseVehicule() > 120) {
            infraction.setMontantFraction(2000);
        } else if (infraction.getVitesseVehicule() > 100) {
            infraction.setMontantFraction(1600);
        } else if (infraction.getVitesseVehicule() > 80) {
            infraction.setMontantFraction(800);
        } else if (infraction.getVitesseVehicule() > 60) {
            infraction.setMontantFraction(400);
        }
        return infractionClient.createInfraction(infraction);
    }

    @GetMapping("/radars/pageRadar")
    public Page<Radar> getPageRadar(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "5") int size) {

        Pageable pageable = PageRequest.of(page, size);
        return radarRepository.findAll(pageable);
    }
    @GetMapping("/radars/pageRadarName/{keyword}")
    public Page<Radar> getRadarsByName(@PathVariable String keyword,
                                       @RequestParam(value = "page", defaultValue = "0") int page,
                                       @RequestParam(value = "size", defaultValue = "5") int size) {

        Pageable pageable = PageRequest.of(page, size);

        if (keyword.equals(null)) return radarRepository.findAll(pageable);
        return radarRepository.findByNameContains(keyword, pageable);
    }

    @GetMapping("/radars/count")
    public Long getRadarsCount() {
        return radarRepository.count();
    }




}
