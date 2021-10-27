package prbd.construction_company.mapper;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import prbd.construction_company.dto.HouseDto;
import prbd.construction_company.entity.House;

@Mapper
public interface HouseMapper {
    CycleAvoidingMappingContext CONTEXT = new CycleAvoidingMappingContext();

    HouseDto toDto(House entity, @Context CycleAvoidingMappingContext context);

    House toEntity(HouseDto dto, @Context CycleAvoidingMappingContext context);

}
