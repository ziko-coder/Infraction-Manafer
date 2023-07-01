package com.example.immatriculationservice.web.graphqlController;


import com.example.immatriculationservice.dto.proprietaireRequest;
import com.example.immatriculationservice.entities.Proprietaire;
import com.example.immatriculationservice.mapper.ProprietaireMapper;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import com.example.immatriculationservice.repositories.ProprietaireRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

//@Controller
@AllArgsConstructor
public class proprietaireGraphQLController {
    private ProprietaireMapper proprietaireMapper;
    private ProprietaireRepository proprietaireRepo;

    //retourner une liste des proprietaires
    @QueryMapping
    public List<Proprietaire> getAllProprietaires() {
        return proprietaireRepo.findAll();
    }

    @QueryMapping
    public Proprietaire getProprietaireById(@Argument Long id) {
        Proprietaire proprietaire=proprietaireRepo.findById(id).orElse(null);
        if(proprietaire==null) throw new RuntimeException(String.format("Owner %s not found",id));
        return proprietaire;
    }

     @MutationMapping
    public Proprietaire saveProprietaire(@Argument proprietaireRequest proprietaire) {
         Proprietaire p = proprietaireMapper.from(proprietaire);
         return proprietaireRepo.save(p);
    }

    @MutationMapping
    public Proprietaire updateProprietaire(@Argument Proprietaire proprietaire, @Argument Long id) {
        proprietaire.setId(id);
        return proprietaireRepo.save(proprietaire);
    }

    @MutationMapping
    public String deleteProprietaire(@Argument Long id) {
        if (proprietaireRepo.existsById(id)) {
            proprietaireRepo.deleteById(id);
            return "Proprietaire [id: " + id + "] has been deleted!";
        }
        return "Proprietaire [id: " + id + "] doesn't exist. Please check the ID entered.";
    }

}