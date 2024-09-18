package saludconecta.citas.ports.driven;

import saludconecta.citas.models.cita.Cita;
import saludconecta.citas.models.consulta.Consulta;

public interface EventPublisher {
    void CitaCreated(Cita cita);

    void CitaConfirmed(Cita cita);

    void CitaCancelled(Cita cita);

    void CitaRescheduled(Cita cita);

    void CitaAttended(Cita cita);

    void CitaUnattended(Cita cita);

    void ConsultaCreated(Consulta consulta);

    void ConsultaCancelled(Consulta consulta);

    void ConsultaStarted(Consulta consulta);

    void ConsultaFinished(Consulta consulta);
}