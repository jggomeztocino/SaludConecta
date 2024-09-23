package saludconecta.citas.adapters.driving;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import saludconecta.citas.dto.cita.CitaDTO;
import saludconecta.citas.services.CitaService;

@Component
public class KafkaEventListener {
    private final CitaService citaService;

    public KafkaEventListener(CitaService citaService) {
        this.citaService = citaService;
    }

    public CitaDTO eventToCitaDTO(String event) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(event, CitaDTO.class); // Conversión JSON --> CitaDTO
        } catch (Exception e) {
            throw new RuntimeException("Error convirtiendo el evento a CitaDTO: " + e.getMessage());
        }
    }

    @KafkaListener(topics = "cita-requested", groupId = "citas")
    public void listenCitaRequested(String event) {
        try {
            citaService.createCita(eventToCitaDTO(event));
        } catch (Exception e) {
            System.err.println("Error procesando el evento 'cita-requested': " + e.getMessage());
        }
    }

    @KafkaListener(topics = "cita-confirmed", groupId = "citas")
    public void listenCitaConfirmed(String event) {
        try {
            citaService.confirmCita(eventToCitaDTO(event));
        } catch (Exception e) {
            System.err.println("Error procesando el evento 'cita-confirmed': " + e.getMessage());
        }
    }

    @KafkaListener(topics = "cita-cancelled", groupId = "citas")
    public void listenCitaCancelled(String event) {
        try {
            citaService.cancelCita(eventToCitaDTO(event));
        } catch (Exception e) {
            System.err.println("Error procesando el evento 'cita-cancelled': " + e.getMessage());
        }
    }

    @KafkaListener(topics = "cita-rescheduled", groupId = "citas")
    public void listenCitaRescheduled(String event) {
        try {
            citaService.rescheduleCita(eventToCitaDTO(event));
        } catch (Exception e) {
            System.err.println("Error procesando el evento 'cita-rescheduled': " + e.getMessage());
        }
    }

    @KafkaListener(topics = "cita-attended", groupId = "citas")
    public void listenCitaAttended(String event) {
        try {
            citaService.attendCita(eventToCitaDTO(event));
        } catch (Exception e) {
            System.err.println("Error procesando el evento 'cita-attended': " + e.getMessage());
        }
    }

    @KafkaListener(topics = "cita-not-attended", groupId = "citas")
    public void listenCitaNotAttended(String event) {
        try {
            citaService.notAttendCita(eventToCitaDTO(event));
        } catch (Exception e) {
            System.err.println("Error procesando el evento 'cita-not-attended': " + e.getMessage());
        }
    }
}
