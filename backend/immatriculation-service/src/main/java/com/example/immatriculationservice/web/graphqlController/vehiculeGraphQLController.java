package com.example.immatriculationservice.web.graphqlController;


import com.example.immatriculationservice.entities.Vehicule;
import com.example.immatriculationservice.repositories.VehiculeRepository;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import java.util.List;import org.springframework.web.bind.annotation.CrossOrigin;

//@Controller
@AllArgsConstructor
public class vehiculeGraphQLController {
    private VehiculeRepository vehiculeRepo;

    @QueryMapping
    public List<Vehicule> getAllVehicules() {
        return vehiculeRepo.findAll();
    }

    @QueryMapping
    public Vehicule getVehiculeById(@Argument Long id) {
        return vehiculeRepo.findById(id).orElse(null);
    }

    @MutationMapping
    public Vehicule saveVehicule(@Argument Vehicule vehicule) {
        return vehiculeRepo.save(vehicule);
    }

    @MutationMapping
    public Vehicule updateVehicule(@Argument Vehicule vehicule, @Argument Long id) {
        vehicule.setId(id);
        return vehiculeRepo.save(vehicule);
    }

    @MutationMapping
    public String deleteVehicule(@Argument Long id) {
        if (vehiculeRepo.existsById(id)) {
            vehiculeRepo.deleteById(id);
            return "Vehicule [id: " + id + "] has been deleted!";
        }
        return "Vehicule [id: " + id + "] doesn't exist. Please check the ID entered.";
    }

}