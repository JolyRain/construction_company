package prbd.construction_company.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prbd.construction_company.entities.Company;
import prbd.construction_company.entities.House;
import prbd.construction_company.repositories.CompanyRep;

import java.util.*;

@Service
public class CompanyService {
    private final CompanyRep companyRep;

    @Autowired
    public CompanyService(CompanyRep companyRep) {
        this.companyRep = companyRep;
    }

    public void addCompany(Company company) {
        companyRep.save(company);
    }

    public Iterable<Company> allCompanies() {
        List<Company> companies = (List<Company>) companyRep.findAll();
        companies.sort(Comparator.comparingInt(Company::getId));
        return companyRep.findAll();
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
