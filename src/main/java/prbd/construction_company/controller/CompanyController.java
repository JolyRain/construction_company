package prbd.construction_company.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import prbd.construction_company.service.CompanyService;

import java.time.format.DateTimeFormatter;

@RequiredArgsConstructor
@Controller
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping
    public String toMainPage() {
        return "redirect:/";
    }

    @GetMapping("{id}")
    public String getCompanyPage(@PathVariable Integer id, Model model) {
            var companyDto = companyService.getCompanyById(id);
            model.addAttribute("company", companyDto);
            model.addAttribute("houses", companyDto.getHouses());
            model.addAttribute("title", "Компания " + companyDto.getName());
            model.addAttribute("dateFormat", DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            return "company";
    }
}
