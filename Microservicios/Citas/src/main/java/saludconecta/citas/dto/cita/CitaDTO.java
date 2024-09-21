package saludconecta.citas.dto.cita;

import saludconecta.citas.models.cita.CitaStates.Estado;
import java.time.LocalDateTime;
import java.util.UUID;

public class CitaDTO {
    private UUID id;
    private UUID paciente;
    private UUID consulta;
    private LocalDateTime fecha;
    private Estado estado;
    private String observaciones;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public UUID getPaciente() {
        return paciente;
    }

    public void setPaciente(UUID paciente) {
        this.paciente = paciente;
    }

    public UUID getConsulta() {
        return consulta;
    }

    public void setConsulta(UUID consulta) {
        this.consulta = consulta;
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