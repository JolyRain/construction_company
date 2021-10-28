package prbd.construction_company.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import prbd.construction_company.dto.ApartmentDto;
import prbd.construction_company.dto.ClientDto;
import prbd.construction_company.dto.CompanyDto;
import prbd.construction_company.service.ApartmentService;
import prbd.construction_company.service.ClientService;
import prbd.construction_company.service.CompanyService;
import prbd.construction_company.service.HouseService;

import java.time.format.DateTimeFormatter;

@RequiredArgsConstructor
@Controller
@RequestMapping("admin")
public class AdminController {

    private static final String REDIRECT_ADMIN_PAGE = "redirect:/admin";
    private final ApartmentService apartmentService;
    private final HouseService houseService;
    private final ClientService clientService;
    private final CompanyService companyService;

    @GetMapping
    public String admin(Model model) {
        model.addAttribute("companies", companyService.allCompanies());
        model.addAttribute("houses", houseService.allHouses());
        model.addAttribute("apartments", apartmentService.allApartments());
        model.addAttribute("clients", clientService.allClients());
        model.addAttribute("dateFormat", DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return "admin";
    }

    //===============crud company===============//
    @GetMapping("company-new")
    public String getCompanyForm() {
        return "company-new";
    }

    @PostMapping("company-new")
    public String createCompany(CompanyDto companyDto) {
        companyService.addCompany(companyDto);
        return REDIRECT_ADMIN_PAGE;
    }

    @GetMapping("company-update/{id}")
    public String getUpdateCompanyForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("company", companyService.getCompanyById(id));
        return "company-new";
    }

    @PostMapping("company-update/{id}")
    public String updateCompany(CompanyDto companyDto, @RequestParam MultipartFile image) {
        companyService.addCompany(companyDto);
        return REDIRECT_ADMIN_PAGE;
    }

    @GetMapping("company-delete/{id}")
    public String deleteCompany(@PathVariable("id") Integer id) {
        companyService.deleteCompany(id);
        return REDIRECT_ADMIN_PAGE;
    }

    //===============crud client===============//
    @GetMapping("client-new")
    public String getClientForm(Model model) {
        model.addAttribute("apartments", apartmentService.allApartments());
        return "new-client";
    }

    @PostMapping("client-new")
    public String newClient(ClientDto clientDto) {
        clientService.addClient(clientDto);
        return REDIRECT_ADMIN_PAGE;
    }

    @GetMapping("client-update/{id}")
    public String getUpdateClientForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("client", clientService.getClientById(id));
        model.addAttribute("apartments", apartmentService.allApartments());
        return "new-client";
    }

    @PostMapping("client-update/{id}")
    public String updateClient(ClientDto clientDto) {
        clientService.addClient(clientDto);
        return REDIRECT_ADMIN_PAGE;
    }

    @GetMapping("client-delete/{id}")
    public String deleteClient(@PathVariable("id") Integer id) {
        clientService.deleteClient(id);
        return REDIRECT_ADMIN_PAGE;
    }

    //===============crud apartments===============//

    @GetMapping("apartment-new")
    public String getApartmentForm(Model model) {
        model.addAttribute("clients", clientService.allClients());
        return "apart-new";
    }

    @PostMapping("apartment-new")
    public String newApartment(ApartmentDto apartmentDto) {
        apartmentService.addApartment(apartmentDto);
        return REDIRECT_ADMIN_PAGE;
    }

    @GetMapping("apartment-update/{id}")
    public String getUpdateApartmentForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("apartment", apartmentService.getApartmentById(id));
        model.addAttribute("apartments", apartmentService.allApartments());
        return "apart-new";
    }

    @PostMapping("apartment-update/{id}")
    public String updateApartment(ApartmentDto apartmentDto) {
        apartmentService.addApartment(apartmentDto);
        return REDIRECT_ADMIN_PAGE;
    }

    @GetMapping("apartment-delete/{id}")
    public String deleteApartment(@PathVariable("id") Integer id) {
        apartmentService.deleteApartment(id);
        return REDIRECT_ADMIN_PAGE;
    }
}
