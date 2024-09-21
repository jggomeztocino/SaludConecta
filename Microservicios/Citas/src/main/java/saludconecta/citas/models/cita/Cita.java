package saludconecta.citas.models.cita;

import javax.validation.constraints.*;

import java.time.LocalDateTime;
import java.util.UUID;

import saludconecta.citas.models.cita.CitaStates.Estado;

public class Cita {
    @NotNull(message = "The ID cannot be null")
    private final UUID id;

    @NotNull(message = "The 'Paciente' ID cannot be null")
    private final UUID paciente;

    @NotNull(message = "The 'Consulta'' ID cannot be null")
    private UUID consulta;

    @NotNull(message = "'Fecha' cannot be null")
    @FutureOrPresent(message = "'Fecha' must be in the present or future")
    private LocalDateTime fecha;

    @NotNull(message = "'Estado' cannot be null")
    private Estado estado;

    @Size(max = 255, message = "'Observaciones' must be less than 255 characters")
    private String observaciones;

    public Cita(UUID id, UUID paciente, UUID consulta, LocalDateTime fecha, Estado estado, String observaciones) {
        this.id = id != null ? id : UUID.randomUUID();
        this.fecha = fecha;
        this.paciente = paciente;
        this.consulta = consulta;
        this.estado = estado != null ? estado : Estado.PENDIENTE;
        this.observaciones = observaciones;
    }

    public UUID getId() {
        return id;
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

    public void confirmar(){
        if (this.estado == Estado.PENDIENTE || this.estado == Estado.REPROGRAMADA){
            this.estado = Estado.CONFIRMADA;
        } else {
            throw new RuntimeException("No se puede confirmar una cita que no está pendiente");
        }
    }

    public void cancelar(){
        if (this.estado == Estado.PENDIENTE || this.estado == Estado.CONFIRMADA || this.estado == Estado.REPROGRAMADA){
            this.estado = Estado.CANCELADA;
        } else {
            throw new RuntimeException("No se puede cancelar una cita que no está pendiente, confirmada o reprogramada");
        }
    }

    public void reprogramar(){
        if (this.estado == Estado.CANCELADA || this.estado == Estado.REPROGRAMADA){
            this.estado = Estado.REPROGRAMADA;
        } else {
            throw new RuntimeException("No se puede reprogramar una cita que no está cancelada o reprogramada");
        }
    }

    public void atender(){
        if (this.estado == Estado.CONFIRMADA){
            this.estado = Estado.ATENDIDA;
        } else {
            throw new RuntimeException("No se puede atender una cita que no está confirmada");
        }
    }

    public void desatender(){
        if (this.estado == Estado.CONFIRMADA){
            this.estado = Estado.DESATENDIDA;
        } else {
            throw new RuntimeException("No se puede desatender una cita que no está confirmada");
        }
    }

}