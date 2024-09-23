package saludconecta.citas.services;

import saludconecta.citas.dto.cita.CitaDTO;
import saludconecta.citas.exceptions.cita.CitaNotFoundException;
import saludconecta.citas.mappers.CitaMapper;
import saludconecta.citas.models.cita.Cita;
import saludconecta.citas.ports.driven.CitaRepository;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CitaService {

    private final CitaRepository citaRepository;
    private final CitaMapper citaMapper;

    public CitaService(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
        this.citaMapper = CitaMapper.INSTANCE;
    }

    public List<CitaDTO> getAllCitas() {
        return citaRepository.findAll().stream()
                .map(citaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<CitaDTO> getCitaById(UUID id) {
        return Optional.ofNullable(citaRepository.findById(id)
                .map(citaMapper::toDTO)
                .orElseThrow(() -> new CitaNotFoundException(id)));
    }

    public CitaDTO createCita(CitaDTO citaDTO) {
        Cita cita = citaMapper.toEntity(citaDTO);
        // Validar cita
        citaRepository.save(cita);
        return citaDTO;
    }

    public void updateCita(UUID id, CitaDTO citaDTO) {
        Cita cita = citaRepository.findById(id)
                .orElseThrow(() -> new CitaNotFoundException(id));

        cita.setFecha(citaDTO.getFecha());
        cita.setConsulta(citaDTO.getConsulta());
        cita.setEstado(citaDTO.getEstado());
        cita.setObservaciones(citaDTO.getObservaciones());
        // Validar cita
        citaRepository.save(cita);
    }

    public void deleteCita(UUID id) {
        Cita cita = citaRepository.findById(id)
                .orElseThrow(() -> new CitaNotFoundException(id));
        citaRepository.delete(id);
    }

    public void confirmCita(CitaDTO citaDTO) {
        Cita cita = citaMapper.toEntity(citaDTO);
        cita.confirmar();
        citaRepository.save(cita);
    }

    public void cancelCita(CitaDTO citaDTO) {
        Cita cita = citaMapper.toEntity(citaDTO);
        cita.cancelar();
        citaRepository.save(cita);
    }

    public void rescheduleCita(CitaDTO citaDTO) {
        Cita cita = citaMapper.toEntity(citaDTO);
        cita.reprogramar();
        citaRepository.save(cita);
    }

    public void attendCita(CitaDTO citaDTO) {
        Cita cita = citaMapper.toEntity(citaDTO);
        cita.atender();
        citaRepository.save(cita);
    }

    public void notAttendCita(CitaDTO citaDTO) {
        Cita cita = citaMapper.toEntity(citaDTO);
        cita.desatender();
        citaRepository.save(cita);
    }
}
