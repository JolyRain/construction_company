package prbd.construction_company.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import prbd.construction_company.entities.Company;
import prbd.construction_company.entities.House;
import prbd.construction_company.repositories.CompanyRep;
import prbd.construction_company.repositories.HouseRep;
import prbd.construction_company.services.CompanyService;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("{id}")
    public String company(@PathVariable String id, Model model) {
        try {
            Company company = companyService.getCompanyById(Integer.parseInt(id)); //чето придумать нада
            model.addAttribute("company", company);
            model.addAttribute("houses", company.getHouses());
            model.addAttribute("title", "Компания " + company.getName());
            return "company";
        } catch (NumberFormatException | NoSuchElementException e) {
            return "redirect:fckn-slave";
        }
    }
}
