package saludconecta.citas.ports.driven;

import saludconecta.citas.models.consulta.Consulta;

import java.util.Optional;
import java.util.UUID;

public interface ConsultaRepository {
    public Optional<Consulta> findById(UUID id);

    public void save(Consulta consulta);
}
