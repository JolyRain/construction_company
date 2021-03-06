package prbd.construction_company.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import prbd.construction_company.dto.CompanyDto;
import prbd.construction_company.exception.NotFoundException;
import prbd.construction_company.mapper.CompanyMapper;
import prbd.construction_company.repository.CompanyRep;

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
        return companyMapper.toDto(companyRep.findById(id)
                .orElseThrow(() -> new NotFoundException("Company not found!")), CompanyMapper.CONTEXT);
    }

    public void deleteCompany(CompanyDto companyDto) {
        companyRep.delete(companyMapper.toEntity(companyDto, CompanyMapper.CONTEXT));
    }

    public void deleteCompany(Integer id) {
        deleteCompany(getCompanyById(id));
    }
}
