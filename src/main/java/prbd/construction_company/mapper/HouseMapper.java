package prbd.construction_company.mapper;

import org.mapstruct.Mapper;
import prbd.construction_company.dto.HouseDto;
import prbd.construction_company.entities.House;

@Mapper
public interface HouseMapper {
    HouseDto toDto(House entity);

    House toEntity(HouseDto dto);

}
