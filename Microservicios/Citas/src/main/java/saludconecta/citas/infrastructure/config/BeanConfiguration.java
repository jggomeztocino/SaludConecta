package saludconecta.citas.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import saludconecta.citas.domain.ports.CitaRepository;
import saludconecta.citas.domain.ports.EventPublisher;
import saludconecta.citas.domain.ports.ConsultaRepository;
import saludconecta.citas.domain.service.CitaService;
import saludconecta.citas.domain.service.ConsultaService;

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