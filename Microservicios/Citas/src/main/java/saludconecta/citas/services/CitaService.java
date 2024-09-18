package saludconecta.citas.services;

import saludconecta.citas.models.cita.Cita;
import saludconecta.citas.ports.driven.CitaRepository;
import saludconecta.citas.ports.driven.EventPublisher;

import java.util.UUID;
import java.time.LocalDateTime;

public class CitaService {
    private final CitaRepository repository;
    private final EventPublisher eventPublisher;

    public CitaService(CitaRepository repository, EventPublisher eventPublisher) {
        this.repository = repository;
        this.eventPublisher = eventPublisher;
    }

    public UUID createCita(LocalDateTime fecha, String pacienteID, String consultaID, Cita.Estado estado,
            String observaciones) {
        Cita cita = new Cita(UUID.randomUUID(), fecha, pacienteID, consultaID, estado, observaciones);
        repository.save(cita);
        eventPublisher.CitaCreated(cita);
        return cita.getID();
    }

    public Cita getCita(UUID id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Cita no encontrada"));
    }

    public void confirmCita(UUID id) {
        Cita cita = getCita(id);
        cita.setEstado(Cita.Estado.CONFIRMADA);
        repository.save(cita);
        eventPublisher.CitaConfirmed(cita);
    }

    public void cancelCita(UUID id) {
        Cita cita = getCita(id);
        cita.setEstado(Cita.Estado.CANCELADA);
        repository.save(cita);
        eventPublisher.CitaCancelled(cita); // Liberar personal y recursos
    }

    public void reschudleCita(UUID id, LocalDateTime nuevaFecha) {
        Cita cita = getCita(id);
        cita.setEstado(Cita.Estado.REPROGRAMADA);
        repository.save(cita);
        eventPublisher.CitaRescheduled(cita); // Reprogramar personal y recursos
    }

    public void attendCita(UUID id) {
        Cita cita = getCita(id);
        cita.setEstado(Cita.Estado.ATENDIDA);
        repository.save(cita);
        eventPublisher.CitaAttended(cita);
    }

    public void unattendedCita(UUID id) {
        Cita cita = getCita(id);
        cita.setEstado(Cita.Estado.DESATENDIDA);
        repository.save(cita);
        eventPublisher.CitaUnattended(cita);
    }
}
