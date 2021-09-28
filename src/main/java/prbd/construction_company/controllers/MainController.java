package prbd.construction_company.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import prbd.construction_company.entities.ConstructionCompany;
import prbd.construction_company.entities.House;
import prbd.construction_company.repositories.CompanyRep;
import prbd.construction_company.repositories.HouseRep;

@Controller
public class MainController {

    @Autowired
    private CompanyRep companyRep;

    @Autowired
    private HouseRep houseRep;

    @GetMapping("/")
    public String test(Model model) {
        ConstructionCompany company = companyRep.findById(1).get();
        House house = new House(company, "address", "address");
        houseRep.save(house);
        return "home";
    }
}
