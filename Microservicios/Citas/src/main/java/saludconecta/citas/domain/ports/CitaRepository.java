package saludconecta.citas.domain.ports;

import saludconecta.citas.domain.entities.Cita;

import java.util.Optional;
import java.util.UUID;

public interface CitaRepository {
    Optional<Cita> findById(UUID id);

    void save(Cita cita);
}
