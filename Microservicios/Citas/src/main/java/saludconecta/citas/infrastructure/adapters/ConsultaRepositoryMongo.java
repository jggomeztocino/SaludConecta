package saludconecta.citas.infrastructure.adapters;

import saludconecta.citas.domain.entities.Consulta;
import saludconecta.citas.domain.ports.ConsultaRepository;

import java.util.Optional;
import java.util.UUID;

public class ConsultaRepositoryMongo implements ConsultaRepository {
    @Override
    public Optional<Consulta> findById(UUID id) {
        // Implementation
        return Optional.empty();
    }

    @Override
    public void save(Consulta consulta) {
        // Implementation
    }
}
