package saludconecta.pacientes.ports.driven;

import java.util.Optional;
import java.util.UUID;
import java.util.List;

import saludconecta.pacientes.models.paciente.Paciente;

public interface PacienteRepository {
    List<Paciente> findAll();
    Optional<Paciente> findById(UUID id);
    void save(Paciente paciente);
    void delete(UUID id);
}
