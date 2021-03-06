package prbd.construction_company.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import prbd.construction_company.service.CompanyService;

@RequiredArgsConstructor
@Controller
public class MainController {

    private final CompanyService companyService;

    @GetMapping
    public String main(Model model) {
        model.addAttribute("title", "Главная");
        model.addAttribute("companies", companyService.allCompanies());
        return "index";
    }

}
