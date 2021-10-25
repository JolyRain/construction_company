package prbd.construction_company.mapper;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import prbd.construction_company.dto.ClientDto;
import prbd.construction_company.dto.CompanyDto;
import prbd.construction_company.entities.Client;
import prbd.construction_company.entities.Company;

@Mapper
public interface ClientMapper {
    CycleAvoidingMappingContext CONTEXT = new CycleAvoidingMappingContext();

    ClientDto toDto(Client entity, @Context CycleAvoidingMappingContext context);

    Client toEntity(ClientDto dto, @Context CycleAvoidingMappingContext context);
}
