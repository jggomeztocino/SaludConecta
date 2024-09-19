package saludconecta.citas.adapters.driven;

import org.springframework.stereotype.Repository;
import saludconecta.citas.models.cita.Cita;
import saludconecta.citas.ports.driven.CitaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class CitaMongoRepository implements CitaRepository {

    @Override
    public List<Cita> findAll() {
        return List.of();
    }

    @Override
    public Optional<Cita> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public void save(Cita cita) {

    }

    @Override
    public void delete(UUID id) {

    }
}
