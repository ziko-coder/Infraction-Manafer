package com.example.infractionservices;

import com.example.infractionservices.entities.Infraction;
import com.example.infractionservices.repositories.InfractionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.boot.CommandLineRunner;


import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class InfractionServicesApplication {
	public static void main(String[] args) {
		SpringApplication.run(InfractionServicesApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(InfractionRepository infractionRepository) {
		return args -> {
			// Create 6 instances of Infraction
			Infraction infraction1 = Infraction.builder()
					.date(new Date())
					.numeroRadar(2L)
					.vitesseMaxRadar(100.0)
					.matriculeVehicule("12AABB")
					.vitesseVehicule(120.0)
					.montantFraction(50.0)
					.ownerName("John Doe")
					.build();

			Infraction infraction2 = Infraction.builder()
					.date(new Date())
					.numeroRadar(2L)
					.vitesseMaxRadar(80.0)
					.matriculeVehicule("z20DD")
					.vitesseVehicule(90.0)
					.montantFraction(30.0)
					.ownerName("Jane Smith")
					.build();
			Infraction infraction3 = Infraction.builder()
					.date(new Date())
					.numeroRadar(3L)
					.vitesseMaxRadar(80.0)
					.matriculeVehicule("XYZ789")
					.vitesseVehicule(80.0)
					.montantFraction(90.0)
					.ownerName("Zakaria Akerdad")
					.build();

			Infraction infraction4 = Infraction.builder()
					.date(new Date())
					.numeroRadar(2L)
					.vitesseMaxRadar(120.0)
					.matriculeVehicule("UIO8942")
					.vitesseVehicule(130.0)
					.montantFraction(20.0)
					.ownerName("khalid Oujnine")
					.build();
			Infraction infraction5 = Infraction.builder()
					.date(new Date())
					.numeroRadar(2L)
					.vitesseMaxRadar(120.0)
					.matriculeVehicule("UIO890")
					.vitesseVehicule(130.0)
					.montantFraction(20.0)
					.ownerName("Jane Doe")
					.build();
			Infraction infraction6 = Infraction.builder()
					.date(new Date())
					.numeroRadar(2L)
					.vitesseMaxRadar(120.0)
					.matriculeVehicule("AFW44890")
					.vitesseVehicule(120.0)
					.montantFraction(20.0)
					.ownerName("Hannae Doe")
					.build();
			Infraction infraction7 = Infraction.builder()
					.date(new Date())
					.numeroRadar(2L)
					.vitesseMaxRadar(120.0)
					.matriculeVehicule("UIO890")
					.vitesseVehicule(99.0)
					.montantFraction(20.0)
					.ownerName("Jane Doe")
					.build();
			Infraction infraction8 = Infraction.builder()
					.date(new Date())
					.numeroRadar(2L)
					.vitesseMaxRadar(120.0)
					.matriculeVehicule("CDEF89021")
					.vitesseVehicule(99.0)
					.montantFraction(20.0)
					.ownerName("Jane Doe")
					.build();





			// Create and save the instances using the repository
			infractionRepository.saveAll(Arrays.asList(infraction1, infraction2, infraction3, infraction4, infraction5, infraction6, infraction7, infraction8));



		};
	}


}
