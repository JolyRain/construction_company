package prbd.construction_company.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import prbd.construction_company.entities.Company;
import prbd.construction_company.repositories.CompanyRep;

@Controller("/")
public class MainController {

    private final CompanyRep companyRep;

    @Autowired
    public MainController(CompanyRep companyRep) {
        this.companyRep = companyRep;
    }

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("title", "Главная");
        Iterable<Company> companies = companyRep.findAll();
        model.addAttribute("companies", companies);
        return "index";
    }

}
