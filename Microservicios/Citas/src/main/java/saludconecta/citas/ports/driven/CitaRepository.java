package saludconecta.citas.ports.driven;

import saludconecta.citas.models.cita.Cita;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CitaRepository {
    List<Cita> findAll();
    Optional<Cita> findById(UUID id);
    void save(Cita cita);
    void delete(UUID id);
}
