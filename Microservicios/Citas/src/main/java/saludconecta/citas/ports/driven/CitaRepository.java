package saludconecta.citas.ports.driven;

import saludconecta.citas.models.cita.Cita;

import java.util.Optional;
import java.util.UUID;

public interface CitaRepository {
    Optional<Cita> findById(UUID id);

    void save(Cita cita);
}
