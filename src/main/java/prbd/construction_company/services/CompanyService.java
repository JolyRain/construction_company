package prbd.construction_company.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import prbd.construction_company.dto.CompanyDto;
import prbd.construction_company.mapper.CompanyMapper;
import prbd.construction_company.repositories.CompanyRep;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CompanyService {

    private final CompanyRep companyRep;
    private final CompanyMapper companyMapper;

    public CompanyDto addCompany(CompanyDto companyDto) {
        companyRep.save(companyMapper.toEntity(companyDto, CompanyMapper.CONTEXT));
        return companyDto;
    }

    public List<CompanyDto> allCompanies() {
        return companyRep.findAll()
                .stream()
                .map(company -> companyMapper.toDto(company, CompanyMapper.CONTEXT))
                .collect(Collectors.toList());
    }

    public CompanyDto getCompanyById(Integer id) {
        //todo обработать исключения
        return companyMapper.toDto(companyRep.findById(id).orElse(null), CompanyMapper.CONTEXT);
    }

    public void deleteCompany(CompanyDto companyDto) {
        companyRep.delete(companyMapper.toEntity(companyDto, CompanyMapper.CONTEXT));
    }

    public void deleteCompany(Integer id) {
        deleteCompany(getCompanyById(id));
    }
}
