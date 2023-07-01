package com.example.infractionservices.web;

import com.example.infractionservices.entities.Infraction;
import com.example.infractionservices.repositories.InfractionRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RestResource
@CrossOrigin(origins = "http://localhost:4200")
public class InfractionRestController {

    private InfractionRepository infractionRepository;

    //private VehiculeRestClient vehicleRestClient;
    //private RadarRestClient radarRestClient;

    @GetMapping("/infractions")
    public List<Infraction> getAllInfractions() {
        return infractionRepository.findAll();
    }

    @GetMapping("/infractions/{id}")
    public Infraction getOneInfraction(@PathVariable long id) {
        return infractionRepository.findById(id).get();
    }

    //Update method :
    @PutMapping("/infractions/{id}")
    public Infraction updateInfraction(@RequestBody Infraction infraction, @PathVariable long id) {
        //PathVariable signifie que le para id se trouve dans URL request http
        //RequestBody signifie que l'objet infraction se trouve dans le corps de request http

        infraction.setId(id); //l'objet infraction chargé dans la requet est déja modifié il faut juste l'inserer dans bdd.
        return infractionRepository.save(infraction);
    }

    //Delete method :
    @DeleteMapping("/infractions/{id}")
    public void deleteInfraction(@PathVariable long id) {
        infractionRepository.deleteById(id);
        System.out.println(">> [Deleting Infraction]: Infraction [ID = " + id + " ] has been deleted successfuly !");
    }

    @PostMapping("/infractions")
    public  Infraction createInfraction(@RequestBody Infraction infraction){
        return infractionRepository.save(infraction);
    }

    @GetMapping("/infractions/count")
    public Long getInfractionsCount() {
        return infractionRepository.count();
    }

}
