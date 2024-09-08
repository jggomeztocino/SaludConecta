package saludconecta.citas.infrastructure.config;

import org.springframework.context.annotation.Bean;

import saludconecta.citas.domain.ports.CitaRepository;
import saludconecta.citas.domain.ports.EventPublisher;
import saludconecta.citas.domain.service.CitaService;

public class BeanConfiguration {

    @Bean
    public CitaService citaService(CitaRepository citaRepository, EventPublisher eventPublisher) {
        return new CitaService(citaRepository, eventPublisher);
    }
}
