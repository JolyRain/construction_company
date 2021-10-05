package prbd.construction_company.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prbd.construction_company.repositories.ApartmentRep;
import prbd.construction_company.repositories.ClientRep;
import prbd.construction_company.repositories.CompanyRep;
import prbd.construction_company.repositories.HouseRep;

@Service
public class AdminService {
    private final ApartmentRep apartmentRep;
    private final HouseRep houseRep;
    private final CompanyRep companyRep;
    private final ClientRep clientRep;

    @Autowired
    public AdminService(ApartmentRep apartmentRep, HouseRep houseRep, CompanyRep companyRep, ClientRep clientRep) {
        this.apartmentRep = apartmentRep;
        this.houseRep = houseRep;
        this.companyRep = companyRep;
        this.clientRep = clientRep;
    }

    public void deleteCompanyById(Integer id) {
        houseRep.deleteById(id);
    }
}
