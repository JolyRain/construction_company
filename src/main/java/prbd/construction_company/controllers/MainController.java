package prbd.construction_company.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import prbd.construction_company.services.CompanyService;

@Controller("/")
public class MainController {

    private final CompanyService companyService;

    @Autowired
    public MainController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public String main(Model model) {
        model.addAttribute("title", "Главная");
        model.addAttribute("companies", companyService.allCompanies());
        return "index";
    }

}
