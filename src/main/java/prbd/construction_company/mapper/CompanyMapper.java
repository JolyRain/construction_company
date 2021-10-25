package prbd.construction_company.mapper;

import org.mapstruct.Mapper;
import prbd.construction_company.dto.CompanyDto;
import prbd.construction_company.entities.Company;

@Mapper
public interface CompanyMapper {

    CompanyDto toDto(Company entity);

    Company toEntity(CompanyDto dto);
}
