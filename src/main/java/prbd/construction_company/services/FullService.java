package prbd.construction_company.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public abstract class FullService {
    private final ApartmentService apartmentService;
    private final HouseService houseService;
    private final ClientService clientService;
    private final CompanyService companyService;

    public FullService(ApartmentService apartmentService, HouseService houseService,
                       ClientService clientService, CompanyService companyService) {
        this.apartmentService = apartmentService;
        this.houseService = houseService;
        this.clientService = clientService;
        this.companyService = companyService;
    }

    public ApartmentService getApartmentService() {
        return apartmentService;
    }

    public HouseService getHouseService() {
        return houseService;
    }

    public ClientService getClientService() {
        return clientService;
    }

    public CompanyService getCompanyService() {
        return companyService;
    }
}
