package saludconecta.pacientes.services;

import org.springframework.stereotype.Service;
import saludconecta.pacientes.dto.paciente.PacienteDTO;
import saludconecta.pacientes.mappers.paciente.PacienteMapper;
import saludconecta.pacientes.models.paciente.Paciente;
import saludconecta.pacientes.ports.driven.PacienteRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PacienteService {
    private final PacienteRepository pacienteRepository;
    private final PacienteMapper pacienteMapper = PacienteMapper.INSTANCE;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public List<PacienteDTO> getAllPacientes() {
        return pacienteRepository.findAll().stream()
                .map(pacienteMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<PacienteDTO> getPacienteById(UUID id) {
        return pacienteRepository.findById(id)
                .map(pacienteMapper::toDTO);
    }

    public PacienteDTO createPaciente(PacienteDTO pacienteDTO) {
        Paciente paciente = pacienteMapper.toEntity(pacienteDTO);
        pacienteRepository.save(paciente);
        return pacienteMapper.toDTO(paciente);
    }

    public void updatePaciente(UUID id, PacienteDTO pacienteDTO) {
        Optional<Paciente> existingPaciente = pacienteRepository.findById(id);
        if (existingPaciente.isPresent()) {
            Paciente paciente = existingPaciente.get();
            paciente.setNombre(pacienteDTO.getNombre());
            paciente.setApellidos(pacienteDTO.getApellidos());
            paciente.setEmail(pacienteDTO.getEmail());
            paciente.setTelefono(pacienteDTO.getTelefono());
            pacienteRepository.save(paciente);
        } else {
            throw new RuntimeException("Paciente no encontrado");
        }
    }

    public void deletePaciente(UUID id) {
        pacienteRepository.delete(id);
    }
}
