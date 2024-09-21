package saludconecta.citas.models.cita;

public class CitaStates {
    public enum Estado {
        PENDIENTE,
        CONFIRMADA,
        CANCELADA,
        REPROGRAMADA,
        ATENDIDA,
        DESATENDIDA
    }
}
