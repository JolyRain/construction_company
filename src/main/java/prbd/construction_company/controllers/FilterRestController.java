package prbd.construction_company.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import prbd.construction_company.entities.Apartment;
import prbd.construction_company.services.ApartmentService;

import java.util.List;

@RestController
@RequestMapping("filter")
public class FilterRestController {
    private final ApartmentService apartmentService;

    @Autowired
    public FilterRestController(ApartmentService apartmentService) {
        this.apartmentService = apartmentService;
    }

    @GetMapping
    public List<Apartment> getApartments() {
        return apartmentService.apartmentList();
    }


}
