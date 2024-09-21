package saludconecta.citas.services;

import saludconecta.citas.dto.cita.CitaDTO;
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
    private final CitaMapper citaMapper = CitaMapper.INSTANCE;

    public CitaService(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    public List<CitaDTO> getAllCitas() {
        return citaRepository.findAll().stream()
                .map(citaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<CitaDTO> getCitaById(UUID id) {
        return citaRepository.findById(id)
                .map(citaMapper::toDTO);
    }

    public CitaDTO createCita(CitaDTO citaDTO) {
        Cita cita = citaMapper.toEntity(citaDTO);
        citaRepository.save(cita);
        return citaMapper.toDTO(cita);
    }

    public void updateCita(UUID id, CitaDTO citaDTO) {
        Optional<Cita> existingCita = citaRepository.findById(id);
        if (existingCita.isPresent()) {
            Cita cita = existingCita.get();
            cita.setFecha(citaDTO.getFecha());
            cita.setConsulta(citaDTO.getConsulta());
            cita.setEstado(citaDTO.getEstado());
            cita.setObservaciones(citaDTO.getObservaciones());
            citaRepository.save(cita);
        } else {
            throw new RuntimeException("Cita no encontrada");
        }
    }

    public void deleteCita(UUID id) {
        citaRepository.delete(id);
    }
}
