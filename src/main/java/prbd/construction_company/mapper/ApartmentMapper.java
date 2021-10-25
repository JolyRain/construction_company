package prbd.construction_company.mapper;

import org.mapstruct.Mapper;
import prbd.construction_company.dto.ApartmentDto;
import prbd.construction_company.entities.Apartment;

@Mapper
public interface ApartmentMapper {

    ApartmentDto toDto(Apartment entity);

    Apartment toEntity(ApartmentDto dto);

}
