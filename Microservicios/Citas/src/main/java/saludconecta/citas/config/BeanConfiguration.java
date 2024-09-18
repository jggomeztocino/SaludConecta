package saludconecta.citas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import saludconecta.citas.ports.driven.CitaRepository;
import saludconecta.citas.ports.driven.EventPublisher;
import saludconecta.citas.ports.driven.ConsultaRepository;
import saludconecta.citas.services.CitaService;
import saludconecta.citas.services.ConsultaService;

@Configuration
public class BeanConfiguration {
    @Bean
    public CitaService citaService(CitaRepository citaRepository, EventPublisher eventPublisher) {
        return new CitaService(citaRepository, eventPublisher);
    }

    @Bean
    public ConsultaService consultaService(ConsultaRepository consultaRepository, EventPublisher eventPublisher) {
        return new ConsultaService(consultaRepository, eventPublisher);
    }
}