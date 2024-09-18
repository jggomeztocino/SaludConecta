package saludconecta.citas.services;

import saludconecta.citas.models.consulta.Consulta;
import saludconecta.citas.ports.driven.ConsultaRepository;
import saludconecta.citas.ports.driven.EventPublisher;

import java.time.LocalDateTime;
import java.util.UUID;

public class ConsultaService {
    private final ConsultaRepository repository;
    private final EventPublisher eventPublisher;

    public ConsultaService(ConsultaRepository repository, EventPublisher eventPublisher) {
        this.repository = repository;
        this.eventPublisher = eventPublisher;
    }

    public UUID createConsulta(LocalDateTime fecha, String medicoID, String pacienteID, Consulta.Estado estado,
            String motivo, String historialMecicoID) {
        Consulta consulta = new Consulta(UUID.randomUUID(), fecha, medicoID, pacienteID, estado, motivo,
                historialMecicoID);
        repository.save(consulta);
        eventPublisher.ConsultaCreated(consulta);
        return consulta.getID();
    }

    public Consulta getConsulta(UUID id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Consulta no encontrada"));
    }

    public void cancelConsulta(UUID id) {
        Consulta consulta = getConsulta(id);
        consulta.setEstado(Consulta.Estado.CANCELADA);
        repository.save(consulta);
        eventPublisher.ConsultaCancelled(consulta);
    }

    public void startConsulta(UUID id) {
        Consulta consulta = getConsulta(id);
        consulta.setEstado(Consulta.Estado.ENCURSO);
        repository.save(consulta);
        eventPublisher.ConsultaStarted(consulta);
    }

    public void finishConsulta(UUID id) {
        Consulta consulta = getConsulta(id);
        consulta.setEstado(Consulta.Estado.FINALIZADA);
        repository.save(consulta);
        eventPublisher.ConsultaFinished(consulta);
    }
}
