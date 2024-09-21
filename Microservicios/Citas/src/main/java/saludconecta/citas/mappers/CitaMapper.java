package saludconecta.citas.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import saludconecta.citas.dto.cita.CitaDTO;
import saludconecta.citas.models.cita.Cita;
import saludconecta.citas.models.cita.CitaStates.Estado;

@Mapper
public interface CitaMapper {
    CitaMapper INSTANCE = Mappers.getMapper(CitaMapper.class);

    @Mapping(source = "estado", target = "estado", qualifiedByName = "estadoToString")
    CitaDTO toDTO(Cita cita);

    @Mapping(source = "estado", target = "estado", qualifiedByName = "stringToEstado")
    Cita toEntity(CitaDTO citaDTO);

    default String estadoToString(Estado estado) {
        return estado != null ? estado.name() : null;
    }

    default Estado stringToEstado(String estado) {
        return estado != null ? Estado.valueOf(estado) : null;
    }
}
