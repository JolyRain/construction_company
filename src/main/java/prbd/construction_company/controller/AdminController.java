package prbd.construction_company.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import prbd.construction_company.dto.ApartmentDto;
import prbd.construction_company.dto.ClientDto;
import prbd.construction_company.dto.CompanyDto;
import prbd.construction_company.dto.HouseDto;
import prbd.construction_company.entity.SaleStatus;
import prbd.construction_company.service.*;

import javax.validation.Valid;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("admin")
public class AdminController {

    private static final String REDIRECT_ADMIN_PAGE = "redirect:/admin";
    private final ApartmentService apartmentService;
    private final HouseService houseService;
    private final ClientService clientService;
    private final CompanyService companyService;
    private final ValidationService validationService;

    @GetMapping
    public String getAdminPage(Model model) {
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
    public String createCompany(@Valid CompanyDto companyDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            var errorsMap = validationService.errorsMap(bindingResult);
            model.mergeAttributes(errorsMap);
            model.addAttribute("company", companyDto);
        } else {
            companyService.addCompany(companyDto);
            model.addAttribute("message", "Компания успешно добавлена");
        }
        return getCompanyForm();
    }

    @GetMapping("company-update/{id}")
    public String getUpdateCompanyForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("company", companyService.getCompanyById(id));
        model.addAttribute("update", true);
        return "company-new";
    }

    @PostMapping("company-update/{id}")
    public String updateCompany(@Valid CompanyDto companyDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            var errorsMap = validationService.errorsMap(bindingResult);
            model.mergeAttributes(errorsMap);
            model.addAttribute("company", companyDto);
        } else {
            companyService.addCompany(companyDto);
            model.addAttribute("message", "Компания успешно изменена");
        }
        return getUpdateCompanyForm(companyDto.getId(), model);
    }

    @GetMapping("company-delete/{id}")
    public String deleteCompany(@PathVariable("id") Integer id) {
        companyService.deleteCompany(id);
        return REDIRECT_ADMIN_PAGE;
    }

    //===============crud house===============//
    @GetMapping("house-new")
    public String getHouseForm(Model model) {
        model.addAttribute("companies", companyService.allCompanies());
        model.addAttribute("dateFormat", DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return "house-new";
    }

    @PostMapping("house-new")
    public String createHouse(HouseDto houseDto, @RequestParam Integer companyId) {
        houseService.addHouse(houseDto, companyId);
        return REDIRECT_ADMIN_PAGE;
    }

    @GetMapping("house-update/{id}")
    public String getUpdateHouseForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("house", houseService.getHouseById(id));
        model.addAttribute("companies", companyService.allCompanies());
        model.addAttribute("dateFormat", DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return "house-new";
    }

    @PostMapping("house-update/{id}")
    public String updateHouse(HouseDto houseDto, @RequestParam Integer companyId) {
        houseService.addHouse(houseDto, companyId);
        return REDIRECT_ADMIN_PAGE;
    }

    @GetMapping("house-delete/{id}")
    public String deleteHouse(@PathVariable("id") Integer id) {
        houseService.deleteHouse(id);
        return REDIRECT_ADMIN_PAGE;
    }

    //===============crud client===============//
    @GetMapping("client-new")
    public String getClientForm(Model model) {
        model.addAttribute("apartments", apartmentService.allApartments());
        return "new-client";
    }

    @PostMapping("client-new")
    public String newClient(ClientDto clientDto,
                            @RequestParam(required = false) List<Integer> apartmentIds) {
        clientService.addClient(clientDto, apartmentIds);
        return REDIRECT_ADMIN_PAGE;
    }

    @GetMapping("client-update/{id}")
    public String getUpdateClientForm(@PathVariable("id") Integer id, Model model) {
        var client = clientService.getClientById(id);
        model.addAttribute("client", client);
        model.addAttribute("apartments", apartmentService.allApartments());
        model.addAttribute("ownApartments", client.getApartments());
        return "new-client";
    }

    @PostMapping("client-update/{id}")
    public String updateClient(ClientDto clientDto,
                               @RequestParam(required = false) List<Integer> apartmentIds) {
        clientService.addClient(clientDto, apartmentIds);
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
        model.addAttribute("houses", houseService.allHouses());
        model.addAttribute("statuses", SaleStatus.values());
        return "apart-new";
    }

    @PostMapping("apartment-new")
    public String newApartment(ApartmentDto apartmentDto, @RequestParam Integer houseId) {
        apartmentService.addApartment(apartmentDto, houseId);
        return REDIRECT_ADMIN_PAGE;
    }

    @GetMapping("apartment-update/{id}")
    public String getUpdateApartmentForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("apartment", apartmentService.getApartmentById(id));
        model.addAttribute("apartments", apartmentService.allApartments());
        model.addAttribute("houses", houseService.allHouses());
        model.addAttribute("statuses", Arrays.asList(SaleStatus.values()));
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
