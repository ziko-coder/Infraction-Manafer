package com.example.immatriculationservice.mapper;

import com.example.immatriculationservice.dto.proprietaireRequest;
import com.example.immatriculationservice.entities.Proprietaire;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProprietaireMapper {
    private  ModelMapper modelMapper;
    public Proprietaire from(proprietaireRequest request){
        Proprietaire proprietaire=new Proprietaire();
        proprietaire.setName(request.getName());
        proprietaire.setEmail(request.getEmail());
        return proprietaire;
    }


}
