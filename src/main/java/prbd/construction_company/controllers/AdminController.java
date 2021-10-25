package prbd.construction_company.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import prbd.construction_company.entities.Apartment;
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

    //===============crud company===============//
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
    public String updateCompany(Company company, @RequestParam MultipartFile image) {
        companyService.addCompany(company);
        return "redirect:/admin";
    }

    @GetMapping("/admin/company-delete/{id}")
    public String deleteCompany(@PathVariable("id") Integer id) {
        companyService.deleteCompany(id);
        return "redirect:/admin";
    }

    //===============crud client===============//
    @GetMapping("/admin/client-new")
    public String newClientForm(Model model) {
        model.addAttribute("apartments", apartmentService.allApartments());
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
            model.addAttribute("apartments", apartmentService.allApartments());
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

    //===============crud apartments===============//

    @GetMapping("/admin/apartment-new")
    public String newApartmentForm(Model model) {
        model.addAttribute("clients", clientService.allClients());
        return "apart-new";
    }

    @PostMapping("/admin/apartment-new")
    public String newApartment(Apartment apartment) {
        apartmentService.addApartment(apartment);
        return "redirect:/admin";
    }

    @GetMapping("/admin/apartment-update/{id}")
    public String updateApartmentForm(@PathVariable("id") String id, Model model) {
        try {
            Apartment apartment = apartmentService.getApartmentById(Integer.parseInt(id));
            if (apartment == null) throw new NoSuchElementException();
            model.addAttribute("apartment", apartment);
            model.addAttribute("apartments", apartmentService.allApartments());
            return "apart-new";
        } catch (NumberFormatException | NoSuchElementException e) {
            return "redirect:/admin";
        }
    }

    @PostMapping("/admin/apartment-update/{id}")
    public String updateApartment(Apartment apartment) {
        apartmentService.addApartment(apartment);
        return "redirect:/admin";
    }

    @GetMapping("/admin/apartment-delete/{id}")
    public String deleteApartment(@PathVariable("id") Integer id) {
        apartmentService.deleteApartment(id);
        return "redirect:/admin";
    }
}
