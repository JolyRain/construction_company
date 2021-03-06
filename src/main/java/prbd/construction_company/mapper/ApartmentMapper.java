package prbd.construction_company.mapper;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import prbd.construction_company.dto.ApartmentDto;
import prbd.construction_company.dto.ApartmentForFilterDto;
import prbd.construction_company.entity.Apartment;

import java.util.List;

@Mapper
public interface ApartmentMapper {
    CycleAvoidingMappingContext CONTEXT = new CycleAvoidingMappingContext();

    ApartmentDto toDto(Apartment entity, @Context CycleAvoidingMappingContext context);

    Apartment toEntity(ApartmentDto dto, @Context CycleAvoidingMappingContext context);

    @Mapping(target = "houseAddress", source = "entity.house.address")
    @Mapping(target = "housePhoto", source = "entity.house.photo")
    @Mapping(target = "companyId", source = "entity.house.company.id")
    @Mapping(target = "houseId", source = "entity.house.id")
    ApartmentForFilterDto toDtoForFilter(Apartment entity);

    List<ApartmentDto> toDtoList(List<Apartment> entityList, @Context CycleAvoidingMappingContext context);

}
