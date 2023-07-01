package com.example.immatriculationservice.web.soapController;


import com.example.immatriculationservice.dto.proprietaireRequest;
import com.example.immatriculationservice.entities.Proprietaire;
import com.example.immatriculationservice.mapper.ProprietaireMapper;
import com.example.immatriculationservice.repositories.ProprietaireRepository;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;



//@Component
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200/")
public class proprietaireSoap {
    private ProprietaireRepository proprietaireRepository;
    private ProprietaireMapper mapper;
    @WebMethod
    public List<Proprietaire> proprietaireList(){
        return proprietaireRepository.findAll();
    }
    //return owner
    @WebMethod
    public Proprietaire proprietaireById(@WebParam(name = "id") Long id){
        return proprietaireRepository.findById(id).orElse(null);
    }
    //savemethod
    @WebMethod
    public  Proprietaire saveProprietaire(@WebParam proprietaireRequest request){
        Proprietaire proprietaire=mapper.from(request);
        return  proprietaireRepository.save(proprietaire);
    }

}
