package com.example.immatriculationservice.web.soapController;

import lombok.AllArgsConstructor;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
@AllArgsConstructor
public class configurationSoap {
    private Bus bus;
    private proprietaireSoap proprietaireSoap;
    @Bean
    public EndpointImpl endpoint(){
        EndpointImpl endpoint=new EndpointImpl(bus,proprietaireSoap);
        endpoint.publish("/ProprietaireService");
        return endpoint;
    }
}
