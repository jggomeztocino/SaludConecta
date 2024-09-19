package saludconecta.pacientes.mappers.paciente;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import saludconecta.pacientes.dto.paciente.PacienteDTO;
import saludconecta.pacientes.models.paciente.Paciente;

@Mapper
public interface PacienteMapper {
    PacienteMapper INSTANCE = Mappers.getMapper(PacienteMapper.class);

    PacienteDTO toDTO(Paciente paciente);

    Paciente toEntity(PacienteDTO pacienteDTO);
}
