package saludconecta.citas.infrastructure.adapters;

import saludconecta.citas.domain.ports.CitaRepository;
import saludconecta.citas.domain.entities.Cita;

import java.util.Optional;
import java.util.UUID;

public class CitaRepositoryMongo implements CitaRepository {
    // Implementation

    @Override
    public Optional<Cita> findById(UUID id) {
        // Implementation
        return Optional.empty();
    }

    @Override
    public void save(Cita cita) {
        // Implementation
    }
}
