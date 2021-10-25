package prbd.construction_company.mapper;

import org.mapstruct.Mapper;
import prbd.construction_company.dto.ClientDto;
import prbd.construction_company.entities.Client;

@Mapper
public interface ClientMapper {
    ClientDto toDto(Client entity);

    Client toEntity(ClientDto dto);

}
