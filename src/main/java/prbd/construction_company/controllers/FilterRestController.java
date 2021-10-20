package prbd.construction_company.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import prbd.construction_company.entities.Apartment;
import prbd.construction_company.entities.Client;
import prbd.construction_company.entities.House;
import prbd.construction_company.services.ApartmentService;
import prbd.construction_company.services.ClientService;
import prbd.construction_company.services.CompanyService;
import prbd.construction_company.services.HouseService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FilterRestController {
    private final ApartmentService apartmentService;
    private final HouseService houseService;
    private final CompanyService companyService;
    private final ClientService clientService;


    @Autowired
    public FilterRestController(ApartmentService apartmentService, HouseService houseService, CompanyService companyService, ClientService clientService) {
        this.apartmentService = apartmentService;
        this.houseService = houseService;
        this.companyService = companyService;
        this.clientService = clientService;
    }

    @RequestMapping(value = "/filter", method = RequestMethod.GET)
    public List<Apartment> getApartments() {
        return apartmentService.apartmentList();
    }


}
