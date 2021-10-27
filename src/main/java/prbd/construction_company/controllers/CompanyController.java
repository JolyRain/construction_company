package prbd.construction_company.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import prbd.construction_company.services.CompanyService;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Controller
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping("{id}")
    public String getCompanyPage(@PathVariable Integer id, Model model) {
        try {
            var companyDto = companyService.getCompanyById(id);
            model.addAttribute("company", companyDto);
            model.addAttribute("houses", companyDto.getHouses());
            model.addAttribute("title", "Компания " + companyDto.getName());
            return "company";
        } catch (NumberFormatException | NoSuchElementException e) {
            return "redirect:error";
        }
    }
}
