package saludconecta.citas.infrastructure.adapters;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import saludconecta.citas.domain.entities.Cita;

import saludconecta.citas.domain.ports.EventPublisher;

@Component
public class KafkaEventPublisher implements EventPublisher {
    private String convertCitaToEvent(Cita cita) {
        return new Gson().toJson(cita);
    }

    @Override
    public void CitaCreated(Cita cita) {
        String event = convertCitaToEvent(cita);
        System.out.println("Publicando evento de creación de cita: " + event);
        // Publicar evento en Kafka
    }

    @Override
    public void CitaConfirmed(Cita cita) {
        String event = convertCitaToEvent(cita);
        System.out.println("Publicando evento de confirmación de cita: " + event);
        // Publicar evento en Kafka
    }

    @Override
    public void CitaCancelled(Cita cita) {
        String event = convertCitaToEvent(cita);
        System.out.println("Publicando evento de cancelación de cita: " + event);
        // Publicar evento en Kafka
    }

    @Override
    public void CitaRescheduled(Cita cita) {
        String event = convertCitaToEvent(cita);
        System.out.println("Publicando evento de reprogramación de cita: " + event);
        // Publicar evento en Kafka
    }

    @Override
    public void CitaAttended(Cita cita) {
        String event = convertCitaToEvent(cita);
        System.out.println("Publicando evento de atención de cita: " + event);
        // Publicar evento en Kafka
    }

    @Override
    public void CitaUnattended(Cita cita) {
        String event = convertCitaToEvent(cita);
        System.out.println("Publicando evento de desatención de cita: " + event);
        // Publicar evento en Kafka
    }
}
