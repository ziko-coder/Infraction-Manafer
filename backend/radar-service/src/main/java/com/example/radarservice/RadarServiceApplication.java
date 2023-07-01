package com.example.radarservice;

import com.example.radarservice.entities.Radar;
import com.example.radarservice.repositories.RadarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
@EnableFeignClients
public class RadarServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RadarServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(RadarRepository radarRepository) {
        return args -> {
            Radar radar1 = Radar.builder()
                    .name("R1")
                    .maxSpeed(100.0)
                    .longitude(123.456)
                    .latitude(78.910)
                    //.numeroRadar("P00")
                    .build();

            radarRepository.save(radar1);
            Radar radar2 = Radar.builder()
                    .name("R2")
                    .maxSpeed(120.3)
                    .longitude(142.456)
                    .latitude(30.910)
                    //.numeroRadar("E56")
                    .build();
            radarRepository.save(radar2);

            Radar radar3 = Radar.builder()
                    .name("R3")
                    .maxSpeed(130.9)
                    .longitude(123.456)
                    .latitude(78.910)
                    .build();
            radarRepository.save(radar3);

            Radar radar4 = Radar.builder()
                    .name("R4")
                    .maxSpeed(142.9)
                    .longitude(43.456)
                    .latitude(78.910)
                    .build();
            radarRepository.save(radar4);

            Radar radar5 = Radar.builder()
                    .name("R5")
                    .maxSpeed(90.9)
                    .longitude(100.0)
                    .latitude(32.412)
                    .build();
            radarRepository.save(radar5);

            Radar radar6 = Radar.builder()
                    .name("R6")
                    .maxSpeed(120.0)
                    .longitude(99.9392)
                    .latitude(132.4)
                    .build();
            radarRepository.save(radar6);

            Radar radar7 = Radar.builder()
                    .name("R7")
                    .maxSpeed(120.33)
                    .longitude(132.13)
                    .latitude(242.42)
                    .build();
            radarRepository.save(radar7);

            Radar radar8 = Radar.builder()
                    .name("R8")
                    .maxSpeed(131.4)
                    .longitude(123.432)
                    .latitude(223.1)
                    .build();
            radarRepository.save(radar8);

            System.out.println("All Radars:");
            radarRepository.findAll().forEach(vehicle -> {
                System.out.println(vehicle.toString());
            });
        };
    }


}
