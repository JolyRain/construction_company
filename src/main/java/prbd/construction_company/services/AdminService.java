package prbd.construction_company.services;

import org.springframework.stereotype.Service;

@Service
public class AdminService {
    private final ApartmentService apartmentService;
    private final HouseService houseService;
    private final ClientService clientService;
    private final CompanyService companyService;

    public AdminService(ApartmentService apartmentService, HouseService houseService,
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
