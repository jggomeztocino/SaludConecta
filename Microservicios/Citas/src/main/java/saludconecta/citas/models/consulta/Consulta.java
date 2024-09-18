package saludconecta.citas.models.consulta;

import java.time.LocalDateTime;
import java.util.UUID;

public class Consulta {
    public enum Estado {
        PROGRAMADA,
        ENCURSO,
        CANCELADA,
        FINALIZADA
    }

    private final UUID ID;
    private LocalDateTime fecha;
    private String medicoID;
    private final String pacienteID;
    private Estado estado;
    private String motivo;
    private String historialMecicoID;

    public Consulta(UUID ID, LocalDateTime fecha, String medicoID, String pacienteID, Estado estado, String motivo,
            String historialMecicoID) {
        this.ID = ID;
        this.fecha = fecha;
        this.medicoID = medicoID;
        this.pacienteID = pacienteID;
        this.estado = estado;
        this.motivo = motivo;
        this.historialMecicoID = historialMecicoID;
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

    public String getMedicoID() {
        return medicoID;
    }

    public void setMedicoID(String medicoID) {
        this.medicoID = medicoID;
    }

    public String getPacienteID() {
        return pacienteID;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getHistorialMecicoID() {
        return historialMecicoID;
    }
}
