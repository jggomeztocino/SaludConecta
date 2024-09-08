package saludconecta.citas.domain.service;

import saludconecta.citas.domain.entities.Cita;
import saludconecta.citas.domain.ports.CitaRepository;
import saludconecta.citas.domain.ports.EventPublisher;

import java.util.UUID;
import java.time.LocalDateTime;

public class CitaService {
    private final CitaRepository repository;
    private final EventPublisher eventPublisher;

    public CitaService(CitaRepository repository, EventPublisher eventPublisher) {
        this.repository = repository;
        this.eventPublisher = eventPublisher;
    }

    public UUID crearCita(LocalDateTime fecha, String pacienteID, String consultaID, Cita.Estado estado,
            String observaciones) {
        Cita cita = new Cita(UUID.randomUUID(), fecha, pacienteID, consultaID, estado, observaciones);
        repository.save(cita);
        eventPublisher.CitaCreated(cita);
        return cita.getID();
    }

    public Cita obtenerCita(UUID id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Cita no encontrada"));
    }

    public void confirmarCita(UUID id) {
        Cita cita = obtenerCita(id);
        cita.confirmar();
        repository.save(cita);
        eventPublisher.CitaConfirmed(cita);
    }

    public void cancelarCita(UUID id) {
        Cita cita = obtenerCita(id);
        cita.cancelar();
        repository.save(cita);
        eventPublisher.CitaCancelled(cita); // Liberar personal y recursos
    }

    public void reprogramarCita(UUID id, LocalDateTime nuevaFecha) {
        Cita cita = obtenerCita(id);
        cita.reprogramar(nuevaFecha);
        repository.save(cita);
        eventPublisher.CitaRescheduled(cita); // Reprogramar personal y recursos
    }

    public void atenderCita(UUID id) {
        Cita cita = obtenerCita(id);
        cita.atender();
        repository.save(cita);
        eventPublisher.CitaAttended(cita);
    }

    public void desatenderCita(UUID id) {
        Cita cita = obtenerCita(id);
        cita.desatender();
        repository.save(cita);
        eventPublisher.CitaUnattended(cita);
    }
}
