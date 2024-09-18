package saludconecta.citas.adapters.driven;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import saludconecta.citas.models.cita.Cita;
import saludconecta.citas.models.consulta.Consulta;

import saludconecta.citas.ports.driven.EventPublisher;

@Component
public class KafkaEventPublisher implements EventPublisher {
    private String convertCitaToEvent(Cita cita) {
        return new Gson().toJson(cita);
    }

    private String convertConsultaToEvent(Consulta consulta) {
        return new Gson().toJson(consulta);
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

    @Override
    public void ConsultaCreated(Consulta consulta) {
        String event = convertConsultaToEvent(consulta);
        System.out.println("Publicando evento de creación de consulta: " + event);
        // Publicar evento en Kafka
    }

    @Override
    public void ConsultaCancelled(Consulta consulta) {
        String event = convertConsultaToEvent(consulta);
        System.out.println("Publicando evento de cancelación de consulta: " + event);
        // Publicar evento en Kafka
    }

    @Override
    public void ConsultaStarted(Consulta consulta) {
        String event = convertConsultaToEvent(consulta);
        System.out.println("Publicando evento de inicio de consulta: " + event);
        // Publicar evento en Kafka
    }

    @Override
    public void ConsultaFinished(Consulta consulta) {
        String event = convertConsultaToEvent(consulta);
        System.out.println("Publicando evento de finalización de consulta: " + event);
        // Publicar evento en Kafka
    }
}
