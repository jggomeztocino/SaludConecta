package saludconecta.citas.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import saludconecta.citas.dto.cita.CitaDTO;
import saludconecta.citas.models.cita.Cita;

@Mapper
public interface CitaMapper {
    CitaMapper INSTANCE = Mappers.getMapper(CitaMapper.class);

    CitaDTO toDTO(Cita cita);

    Cita toEntity(CitaDTO citaDTO);
}
