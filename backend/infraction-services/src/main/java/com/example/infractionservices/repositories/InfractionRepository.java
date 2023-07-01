package com.example.infractionservices.repositories;

import com.example.infractionservices.entities.Infraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface InfractionRepository extends JpaRepository<Infraction,Long> {
}