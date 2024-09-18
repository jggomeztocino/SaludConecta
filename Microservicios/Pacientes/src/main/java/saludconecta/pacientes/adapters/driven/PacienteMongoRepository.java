package saludconecta.pacientes.adapters.driven;

import org.springframework.stereotype.Repository;
import saludconecta.pacientes.models.paciente.Paciente;
import saludconecta.pacientes.ports.driven.PacienteRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class PacienteMongoRepository implements PacienteRepository {

    @Override
    public List<Paciente> findAll() {
        return List.of();
    }

    @Override
    public Optional<Paciente> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public void save(Paciente paciente) {

    }

    @Override
    public void delete(UUID id) {

    }
}
