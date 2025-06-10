package com.mst.semillero.tallerrcon.config;

import com.fasterxml.jackson.jakarta.rs.json.JacksonJsonProvider;
import com.mst.semillero.tallerrcon.service.AnimalService;
import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.List;

@Configuration
public class CxfConfig {
    @Bean
    public Server rsServer(Bus bus, AnimalService animalService) {
        JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();
        endpoint.setBus(bus);
        endpoint.setServiceBeans(Collections.singletonList(animalService));
        endpoint.setProviders(List.of(new JacksonJsonProvider()));
        endpoint.setAddress("/api"); //Ruta base que se fija a todos los endpoints de este proyecto
        return endpoint.create();
    }
}
