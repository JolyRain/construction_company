package prbd.construction_company.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import prbd.construction_company.entities.Company;
import prbd.construction_company.entities.House;
import prbd.construction_company.repositories.CompanyRep;

import java.util.*;

@RequiredArgsConstructor
@Service
public class CompanyService {

    private final CompanyRep companyRep;

    public void addCompany(Company company) {
        companyRep.save(company);
    }

    public Iterable<Company> allCompanies() {
        return companyRep.findAll(Sort.by(Sort.Order.by("name")).ascending());
    }

    public Company getCompanyById(Integer id) {
        Optional<Company> company = companyRep.findById(id);
        return company.orElse(null);
    }

    public void updateCompany(Integer id, String newName, String newDescription, String newLogo) {
        Company company = getCompanyById(id);
        company.setName(newName);
        company.setDescription(newDescription);
        company.setLogo(newLogo);
        addCompany(company);
    }

    //надо обработать исключения
    public void deleteCompany(Company company) {
        companyRep.delete(company);
    }

    public void deleteCompany(Integer id) {
        companyRep.deleteById(id);
    }

    public Set<House> allHousesById(Integer id) {
        return getCompanyById(id).getHouses();
    }

}
