package saludconecta.citas.adapters.driven;

import saludconecta.citas.ports.driven.CitaRepository;
import saludconecta.citas.models.cita.Cita;

import java.util.Optional;
import java.util.UUID;

public class CitaRepositoryMongo implements CitaRepository {
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
