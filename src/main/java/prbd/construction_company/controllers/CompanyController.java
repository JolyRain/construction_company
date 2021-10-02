package prbd.construction_company.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import prbd.construction_company.entities.Company;
import prbd.construction_company.entities.House;
import prbd.construction_company.repositories.CompanyRep;
import prbd.construction_company.repositories.HouseRep;

import java.util.NoSuchElementException;
import java.util.Optional;

@Controller("/company")
public class CompanyController {

    private final CompanyRep companyRep;
    private final HouseRep houseRep;

    @Autowired
    public CompanyController(CompanyRep companyRep, HouseRep houseRep) {
        this.companyRep = companyRep;
        this.houseRep = houseRep;
    }

    @GetMapping("/company/{id}")
    public String company(@PathVariable String id, Model model) {
        try {
            Optional<Company> optionalCompany = companyRep.findById(Integer.parseInt(id));    //исправить эту гадость
            Company company = optionalCompany.get();
            Iterable<House> houses = houseRep.findAllByCompany(company);
            model.addAttribute("company", company);
            model.addAttribute("houses", houses);
            model.addAttribute("title", "Компания " + company.getName());
            return "company";
        } catch (NumberFormatException | NoSuchElementException e) {
            return "redirect:fckn-slave";
        }
    }
}
