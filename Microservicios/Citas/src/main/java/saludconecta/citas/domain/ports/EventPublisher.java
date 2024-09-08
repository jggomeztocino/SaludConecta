package saludconecta.citas.domain.ports;

import saludconecta.citas.domain.entities.Cita;

public interface EventPublisher {
    void CitaCreated(Cita cita);

    void CitaConfirmed(Cita cita);

    void CitaCancelled(Cita cita);

    void CitaRescheduled(Cita cita);

    void CitaAttended(Cita cita);

    void CitaUnattended(Cita cita);
}