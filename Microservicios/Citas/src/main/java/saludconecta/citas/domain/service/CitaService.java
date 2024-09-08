package saludconecta.citas.domain.service;

import saludconecta.citas.domain.entities.Cita;
import saludconecta.citas.domain.repository.CitaRepository;

import java.util.UUID;
import java.time.LocalDateTime;

public class CitaService {
    private final CitaRepository repository;

    public CitaService(CitaRepository repository) {
        this.repository = repository;
    }

    public UUID crearCita(LocalDateTime fecha, String pacienteID, String consultaID, Cita.Estado estado,
            String observaciones) {
        Cita cita = new Cita(UUID.randomUUID(), fecha, pacienteID, consultaID, estado, observaciones);
        repository.save(cita);
        return cita.getID();
    }

    public Cita obtenerCita(UUID id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Cita no encontrada"));
    }

    public void confirmarCita(UUID id) {
        Cita cita = obtenerCita(id);
        cita.confirmar();
        repository.save(cita);
    }

    public void cancelarCita(UUID id) {
        Cita cita = obtenerCita(id);
        cita.cancelar();
        // Liberar personal y recursos
        repository.save(cita);
    }

    public void reprogramarCita(UUID id, LocalDateTime nuevaFecha) {
        Cita cita = obtenerCita(id);
        cita.reprogramar(nuevaFecha);
        // Reprogramar personal y recursos
        repository.save(cita);
    }

    public void atenderCita(UUID id) {
        Cita cita = obtenerCita(id);
        cita.atender();
        repository.save(cita);
    }

    public void desatenderCita(UUID id) {
        Cita cita = obtenerCita(id);
        cita.desatender();
        repository.save(cita);
    }
}
