package saludconecta.citas.domain.ports;

import saludconecta.citas.domain.entities.Consulta;

import java.util.Optional;
import java.util.UUID;

public interface ConsultaRepository {
    public Optional<Consulta> findById(UUID id);

    public void save(Consulta consulta);
}
