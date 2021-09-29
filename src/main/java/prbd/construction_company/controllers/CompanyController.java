package prbd.construction_company.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import prbd.construction_company.entities.ConstructionCompany;
import prbd.construction_company.entities.House;
import prbd.construction_company.repositories.CompanyRep;
import prbd.construction_company.repositories.HouseRep;

import java.util.NoSuchElementException;
import java.util.Optional;

@Controller("/company")
public class CompanyController {
    @Autowired
    private CompanyRep companyRep;

    @Autowired
    private HouseRep houseRep;

    @GetMapping("/company/{id}")
    public String company(@PathVariable String id, Model model) {
        try {
            Optional<ConstructionCompany> optionalCompany = companyRep.findById(Integer.parseInt(id));    //исправить эту гадость
            ConstructionCompany company = optionalCompany.get();
            Iterable<House> houses = houseRep.findAllByCompany(company);
            model.addAttribute("company", company);
            model.addAttribute("houses", houses);
            return "company";
        } catch (NumberFormatException | NoSuchElementException e) {
            return "redirect:/";
        }
    }
}
