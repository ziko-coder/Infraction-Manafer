package com.example.radarservice.feignClients;


import com.example.radarservice.models.Infraction;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "INFRACTION-SERVICE",url = "http://localhost:8081")
public interface InfractionClient {
    @PostMapping ("/infractions")
    Infraction createInfraction(@RequestBody Infraction infraction);

}
