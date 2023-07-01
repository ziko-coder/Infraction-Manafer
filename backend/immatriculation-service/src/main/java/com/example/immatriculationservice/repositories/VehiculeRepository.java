package com.example.immatriculationservice.repositories;

import com.example.immatriculationservice.entities.Vehicule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource
public interface VehiculeRepository extends JpaRepository<Vehicule,Long> {
    public Collection<Vehicule> getVehiculeByProprietaireId(long id);
    //Vehicule findByMatricule(String matricule);


    //used in gRPC
    @Query("SELECT v FROM Vehicule v WHERE v.id LIKE ?1")
    Vehicule selectById(Long id);

    @Query("SELECT v.proprietaire.id FROM Vehicule v WHERE v.id LIKE ?1")
    long selectProprietaireByIdVehicule(long id);

    @Query("SELECT v FROM Vehicule v WHERE v.registrationNumber = :matricule")
    Vehicule findByMatricule(@Param("matricule") String matricule);




    Vehicule findVehicleByRegistrationNumber(String rn);

    Page<Vehicule> findByRegistrationNumberContaining(String keyword, Pageable pageable);

    Vehicule findByRegistrationNumber(String registrationNumber);

}
