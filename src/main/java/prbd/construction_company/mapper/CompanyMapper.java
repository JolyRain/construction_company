package prbd.construction_company.mapper;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import prbd.construction_company.dto.CompanyDto;
import prbd.construction_company.entities.Company;

@Mapper
public interface CompanyMapper {
    CycleAvoidingMappingContext CONTEXT = new CycleAvoidingMappingContext();

    CompanyDto toDto(Company entity, @Context CycleAvoidingMappingContext context);

    Company toEntity(CompanyDto dto, @Context CycleAvoidingMappingContext context);
}
