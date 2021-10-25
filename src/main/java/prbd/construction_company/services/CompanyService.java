package prbd.construction_company.services;

import lombok.RequiredArgsConstructor;
import org.mapstruct.Context;
import org.springframework.stereotype.Service;
import prbd.construction_company.dto.CompanyDto;
import prbd.construction_company.dto.HouseDto;
import prbd.construction_company.entities.Company;
import prbd.construction_company.entities.House;
import prbd.construction_company.mapper.CompanyMapper;
import prbd.construction_company.mapper.CycleAvoidingMappingContext;
import prbd.construction_company.repositories.CompanyRep;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class CompanyService {

    private final CompanyRep companyRep;
    private final CompanyMapper companyMapper;
    private final CycleAvoidingMappingContext context;

    public CompanyDto addCompany(CompanyDto companyDto) {
        companyRep.save(companyMapper.toEntity(companyDto, context));
        return companyDto;
    }

    public List<CompanyDto> allCompanies() {
        var companyDtoList = new ArrayList<CompanyDto>();
        companyRep.findAll().forEach(company -> companyDtoList.add(companyMapper.toDto(company, context)));
        return companyDtoList;
    }

    public CompanyDto getCompanyById(Integer id) {
        return companyMapper.toDto(companyRep.findById(id).orElse(null), context);
    }

    public void updateCompany(Integer id, String newName, String newDescription, String newLogo) {
        var companyDto = getCompanyById(id);
        companyDto.setName(newName);
        companyDto.setDescription(newDescription);
        companyDto.setLogo(newLogo);
        addCompany(companyDto);
    }

    //надо обработать исключения
    public CompanyDto deleteCompany(CompanyDto companyDto) {
        companyRep.delete(companyMapper.toEntity(companyDto, context));
        return companyDto;
    }

    public CompanyDto deleteCompany(Integer id) {
        var companyDto = getCompanyById(id);
        deleteCompany(companyDto);
        return companyDto;
    }

    public Set<HouseDto> allHousesById(Integer id) {
        return getCompanyById(id).getHouses();
    }

}
