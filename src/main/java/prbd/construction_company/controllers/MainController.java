package prbd.construction_company.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import prbd.construction_company.repositories.CompanyRep;

@Controller
public class MainController {

    @Autowired
    private CompanyRep companyRep;

    @GetMapping("/")
    public String main(Model model) {
        System.out.println("aadadsa");
        model.addAttribute("title", "Главная");
        return "index";
    }

}
