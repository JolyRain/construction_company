package prbd.construction_company.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import prbd.construction_company.dto.CompanyDto;
import prbd.construction_company.entities.Company;
import prbd.construction_company.services.CompanyService;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Controller
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping("{id}")
    public String company(@PathVariable String id, Model model) {
        try {
            var companyDto = companyService.getCompanyById(Integer.parseInt(id)); //чето придумать нада
            model.addAttribute("company", companyDto);
            model.addAttribute("houses", companyDto.getHouses());
            model.addAttribute("title", "Компания " + companyDto.getName());
            return "company";
        } catch (NumberFormatException | NoSuchElementException e) {
            return "redirect:fckn-slave";
        }
    }
}
