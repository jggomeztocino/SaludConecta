package saludconecta.citas.adapters.driven;

import saludconecta.citas.models.consulta.Consulta;
import saludconecta.citas.ports.driven.ConsultaRepository;

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
