package saludconecta.citas.domain.entities;

import java.time.LocalDateTime;
import java.util.UUID;

public class Cita {
    public enum Estado {
        PENDIENTE,
        CONFIRMADA,
        CANCELADA,
        REPROGRAMADA,
        ATENDIDA,
        DESATENDIDA
    }

    private final UUID ID;
    private LocalDateTime fecha;
    private final String pacienteID;
    private String consultaID;
    private Estado estado;
    private String observaciones;

    public Cita(UUID ID, LocalDateTime fecha, String pacienteID, String consultaID, Estado estado,
            String observaciones) {
        this.ID = ID;
        this.fecha = fecha;
        this.pacienteID = pacienteID;
        this.consultaID = consultaID;
        this.estado = estado;
        this.observaciones = observaciones;
    }

    public UUID getID() {
        return ID;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getPacienteID() {
        return pacienteID;
    }

    public String getConsultaID() {
        return consultaID;
    }

    public void setConsultaID(String consultaID) {
        this.consultaID = consultaID;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}