package prbd.construction_company.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService extends FullService {
    @Autowired
    public AdminService(ApartmentService apartmentService, HouseService houseService,
                        ClientService clientService, CompanyService companyService) {
        super(apartmentService, houseService, clientService, companyService);
    }



}
