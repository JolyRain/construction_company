package prbd.construction_company.mapper;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import prbd.construction_company.dto.ApartmentDto;
import prbd.construction_company.entities.Apartment;

@Mapper
public interface ApartmentMapper {
    CycleAvoidingMappingContext CONTEXT = new CycleAvoidingMappingContext();

    ApartmentDto toDto(Apartment entity, @Context CycleAvoidingMappingContext context);

    Apartment toEntity(ApartmentDto dto, @Context CycleAvoidingMappingContext context);

}
