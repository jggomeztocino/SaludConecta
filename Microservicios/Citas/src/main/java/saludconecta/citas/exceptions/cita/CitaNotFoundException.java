package saludconecta.citas.exceptions.cita;

import java.util.UUID;

public class CitaNotFoundException extends RuntimeException {
    public CitaNotFoundException(UUID id) {
        super("Cita con ID " + id + " no encontrada.");
    }
}

