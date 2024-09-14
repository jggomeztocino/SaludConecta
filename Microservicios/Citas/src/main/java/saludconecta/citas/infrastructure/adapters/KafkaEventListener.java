package saludconecta.citas.infrastructure.adapters;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import com.google.gson.Gson;

import saludconecta.citas.domain.entities.Cita;
import saludconecta.citas.domain.entities.Consulta;
import saludconecta.citas.domain.ports.EventListener;

@Component
public class KafkaEventListener implements EventListener {

    @Override
    @KafkaListener(topics = { "citas, consultas" }) // TO-DO: Change to the correct topics once designed
    public void listenEvents(String message) {
        System.out.println("KafkaEventListener: " + message);
        handleEvent(message);
    }

    private void handleEvent(String message) { // TO-DO: Implement the logic to handle the events
        Gson gson = new Gson();

        Cita cita = gson.fromJson(message, Cita.class); // Event to cita object conversion
        if (cita != null) {
            System.out.println("Cita: " + cita);
            return;
        }

        Consulta consulta = gson.fromJson(message, Consulta.class); // Event to consulta object conversion
        if (consulta != null) {
            System.out.println("Consulta: " + consulta);
            return;
        }

        System.out.println("Not recognised event: " + message);
    }
}
