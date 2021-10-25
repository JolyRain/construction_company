package prbd.construction_company.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import prbd.construction_company.dto.ApartmentDto;
import prbd.construction_company.dto.ClientDto;
import prbd.construction_company.dto.CompanyDto;
import prbd.construction_company.entities.Apartment;
import prbd.construction_company.entities.Client;
import prbd.construction_company.entities.Company;
import prbd.construction_company.services.ApartmentService;
import prbd.construction_company.services.ClientService;
import prbd.construction_company.services.CompanyService;
import prbd.construction_company.services.HouseService;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Controller("/admin")
public class AdminController {

    private final ApartmentService apartmentService;
    private final HouseService houseService;
    private final ClientService clientService;
    private final CompanyService companyService;

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("companies", companyService.allCompanies());
        model.addAttribute("houses", houseService.allHouses());
        model.addAttribute("apartments", apartmentService.allApartments());
        model.addAttribute("clients", clientService.allClients());
        return "admin";
    }

    //===============crud company===============//
    @GetMapping("/admin/company-new")
    public String createCompanyForm() {
        return "company-new";
    }

    @PostMapping("/admin/company-new")
    public String createCompany(CompanyDto companyDto) {
        companyService.addCompany(companyDto);
        return "redirect:/admin";
    }

    //controllerAdvice | exceptionHandler
    @GetMapping("/admin/company-update/{id}")
    public String updateCompanyForm(@PathVariable("id") String id, Model model) {
        try {
            var companyDto = companyService.getCompanyById(Integer.parseInt(id));
            if (companyDto == null) throw new NoSuchElementException();
            model.addAttribute("company", companyDto);
            return "company-new";
        } catch (NumberFormatException | NoSuchElementException e) {
            return "redirect:/admin";
        }
    }

    @PostMapping("/admin/company-update/{id}")
    public String updateCompany(CompanyDto companyDto, @RequestParam MultipartFile image) {
        companyService.addCompany(companyDto);
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
    public String newClient(ClientDto clientDto) {
        clientService.addClient(clientDto);
        return "redirect:/admin";
    }

    @GetMapping("/admin/client-update/{id}")
    public String updateClientForm(@PathVariable("id") String id, Model model) {
        try {
            var clientDto = clientService.getClientById(Integer.parseInt(id));
            if (clientDto == null) throw new NoSuchElementException();
            model.addAttribute("client", clientDto);
            model.addAttribute("apartments", apartmentService.allApartments());
            return "new-client";
        } catch (NumberFormatException | NoSuchElementException e) {
            return "redirect:/admin";
        }
    }

    @PostMapping("/admin/client-update/{id}")
    public String updateClient(ClientDto clientDto) {
        clientService.addClient(clientDto);
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
    public String newApartment(ApartmentDto apartmentDto) {
        apartmentService.addApartment(apartmentDto);
        return "redirect:/admin";
    }

    @GetMapping("/admin/apartment-update/{id}")
    public String updateApartmentForm(@PathVariable("id") String id, Model model) {
        try {
            var apartmentDto = apartmentService.getApartmentById(Integer.parseInt(id));
            if (apartmentDto == null) throw new NoSuchElementException();
            model.addAttribute("apartment", apartmentDto);
            model.addAttribute("apartments", apartmentService.allApartments());
            return "apart-new";
        } catch (NumberFormatException | NoSuchElementException e) {
            return "redirect:/admin";
        }
    }

    @PostMapping("/admin/apartment-update/{id}")
    public String updateApartment(ApartmentDto apartmentDto) {
        apartmentService.addApartment(apartmentDto);
        return "redirect:/admin";
    }

    @GetMapping("/admin/apartment-delete/{id}")
    public String deleteApartment(@PathVariable("id") Integer id) {
        apartmentService.deleteApartment(id);
        return "redirect:/admin";
    }
}
