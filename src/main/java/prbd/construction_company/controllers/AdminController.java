package prbd.construction_company.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import prbd.construction_company.entities.Client;
import prbd.construction_company.entities.Company;
import prbd.construction_company.repositories.ApartmentRep;
import prbd.construction_company.repositories.ClientRep;
import prbd.construction_company.repositories.CompanyRep;
import prbd.construction_company.repositories.HouseRep;

@Controller("/admin")
public class AdminController {

    private final ApartmentRep apartmentRep;
    private final HouseRep houseRep;
    private final CompanyRep companyRep;
    private final ClientRep clientRep;

    @Autowired
    public AdminController(ApartmentRep apartmentRep, HouseRep houseRep, CompanyRep companyRep, ClientRep clientRep) {
        this.apartmentRep = apartmentRep;
        this.houseRep = houseRep;
        this.companyRep = companyRep;
        this.clientRep = clientRep;
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("companies", companyRep.findAll());
        model.addAttribute("houses", houseRep.findAll());
        model.addAttribute("clients", clientRep.findAll());
        model.addAttribute("apartments", apartmentRep.findAll());
        return "admin";
    }

    @DeleteMapping("/admin/delete/")
    public String delete(@RequestBody Company company) {
        companyRep.delete(company);
        return "admin";
    }
}
