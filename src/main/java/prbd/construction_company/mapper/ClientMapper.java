package prbd.construction_company.mapper;

import org.mapstruct.*;
import prbd.construction_company.dto.ClientDto;
import prbd.construction_company.entity.Client;

public interface ClientMapper {
    CycleAvoidingMappingContext CONTEXT = new CycleAvoidingMappingContext();

    ClientDto toDto(Client entity, @Context CycleAvoidingMappingContext context);

    Client toEntity(ClientDto dto, @Context CycleAvoidingMappingContext context);
}
