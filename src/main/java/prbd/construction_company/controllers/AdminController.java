package prbd.construction_company.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import prbd.construction_company.entities.Client;
import prbd.construction_company.entities.Company;
import prbd.construction_company.services.ApartmentService;
import prbd.construction_company.services.ClientService;
import prbd.construction_company.services.CompanyService;
import prbd.construction_company.services.HouseService;

import java.util.NoSuchElementException;

@Controller("/admin")
public class AdminController {

    private final ApartmentService apartmentService;
    private final HouseService houseService;
    private final ClientService clientService;
    private final CompanyService companyService;

    @Autowired
    public AdminController(ApartmentService apartmentService, HouseService houseService,
                           ClientService clientService, CompanyService companyService) {
        this.apartmentService = apartmentService;
        this.houseService = houseService;
        this.clientService = clientService;
        this.companyService = companyService;
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("companies", companyService.allCompanies());
        model.addAttribute("houses", houseService.allHouses());
        model.addAttribute("clients", clientService.allClients());
        model.addAttribute("apartments", apartmentService.allApartments());
        return "admin";
    }

    @GetMapping("/admin/company-new")
    public String createCompanyForm() {
        return "company-new";
    }

    @PostMapping("/admin/company-new")
    public String createCompany(Company company) {
        companyService.addCompany(company);
        return "redirect:/admin";
    }

    //controllerAdvice | exceptionHandler
    @GetMapping("/admin/company-update/{id}")
    public String updateCompanyForm(@PathVariable("id") String id, Model model) {
        try {
            Company company = companyService.getCompanyById(Integer.parseInt(id));
            if (company == null) throw new NoSuchElementException();
            model.addAttribute("company", company);
            return "company-new";
        } catch (NumberFormatException | NoSuchElementException e) {
            return "redirect:/admin";
        }
    }

    @PostMapping("/admin/company-update/{id}")
    public String updateCompany(Company company) {
        companyService.addCompany(company);
        return "redirect:/admin";
    }

    @GetMapping("/admin/company-delete/{id}")
    public String deleteCompany(@PathVariable("id") Integer id) {
        companyService.deleteCompany(id);
        return "redirect:/admin";
    }

    @GetMapping("/admin/client-new")
    public String newClientForm() {
        return "new-client";
    }

    @PostMapping("/admin/client-new")
    public String newClient(Client client) {
        clientService.addClient(client);
        return "redirect:/admin";
    }

    @GetMapping("/admin/client-update/{id}")
    public String updateClientForm(@PathVariable("id") String id, Model model) {
        try {
            Client client = clientService.getClientById(Integer.parseInt(id));
            if (client == null) throw new NoSuchElementException();
            model.addAttribute("client", client);
            return "new-client";
        } catch (NumberFormatException | NoSuchElementException e) {
            return "redirect:/admin";
        }
    }

    @PostMapping("/admin/client-update/{id}")
    public String updateClient(Client client) {
        clientService.addClient(client);
        return "redirect:/admin";
    }

    @GetMapping("/admin/client-delete/{id}")
    public String deleteClient(@PathVariable("id") Integer id) {
        clientService.deleteClient(id);
        return "redirect:/admin";
    }
}
