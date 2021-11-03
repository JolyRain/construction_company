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
    public String createHouse(@Valid HouseDto houseDto, BindingResult bindingResult, Model model,
                              @RequestParam Integer companyId) {
        if (bindingResult.hasErrors()) {
            var errorsMap = validationService.errorsMap(bindingResult);
            model.mergeAttributes(errorsMap);
            model.addAttribute("house", houseDto);
        } else {
            houseService.addHouse(houseDto, companyId);
            model.addAttribute("message", "Дом успешно добавлен");
        }
        return getHouseForm(model);
    }

    @GetMapping("house-update/{id}")
    public String getUpdateHouseForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("house", houseService.getHouseById(id));
        model.addAttribute("companies", companyService.allCompanies());
        model.addAttribute("dateFormat", DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        model.addAttribute("update", true);
        return "house-new";
    }

    @PostMapping("house-update/{id}")
    public String updateHouse(@Valid HouseDto houseDto, BindingResult bindingResult, Model model,
                              @RequestParam Integer companyId) {
        if (bindingResult.hasErrors()) {
            var errorsMap = validationService.errorsMap(bindingResult);
            model.mergeAttributes(errorsMap);
            model.addAttribute("house", houseDto);
        } else {
            houseService.addHouse(houseDto, companyId);
            model.addAttribute("message", "Дом успешно изменен");
        }
        return getUpdateHouseForm(houseDto.getId(), model);
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
    public String newClient(@Valid ClientDto clientDto, BindingResult bindingResult, Model model,
                            @RequestParam(required = false) List<Integer> apartmentIds) {
        if (bindingResult.hasErrors()) {
            var errorsMap = validationService.errorsMap(bindingResult);
            model.mergeAttributes(errorsMap);
            model.addAttribute("client", clientDto);
        } else {
            clientService.addClient(clientDto, apartmentIds);
            model.addAttribute("message", "Клиент успешно добавлен");
        }
        return getClientForm(model);
    }

    @GetMapping("client-update/{id}")
    public String getUpdateClientForm(@PathVariable("id") Integer id, Model model) {
        var client = clientService.getClientById(id);
        model.addAttribute("client", client);
        model.addAttribute("apartments", apartmentService.allApartments());
        model.addAttribute("ownApartments", client.getApartments());
        model.addAttribute("update", true);
        return "new-client";
    }

    @PostMapping("client-update/{id}")
    public String updateClient(@Valid ClientDto clientDto, BindingResult bindingResult, Model model,
                               @RequestParam(required = false) List<Integer> apartmentIds) {
        if (bindingResult.hasErrors()) {
            var errorsMap = validationService.errorsMap(bindingResult);
            model.mergeAttributes(errorsMap);
            model.addAttribute("client", clientDto);
        } else {
            clientService.addClient(clientDto, apartmentIds);
            model.addAttribute("message", "Клиент успешно изменен");
        }
        return getUpdateClientForm(clientDto.getId(), model);
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
    public String newApartment(@Valid ApartmentDto apartmentDto, BindingResult bindingResult, Model model,
                               @RequestParam Integer houseId) {
        if (bindingResult.hasErrors()) {
            var errorsMap = validationService.errorsMap(bindingResult);
            model.mergeAttributes(errorsMap);
            model.addAttribute("apartment", apartmentDto);
        } else {
            apartmentService.addApartment(apartmentDto, houseId);
            model.addAttribute("message", "Квартира успешно добавлена");
        }
        return getApartmentForm(model);
    }

    @GetMapping("apartment-update/{id}")
    public String getUpdateApartmentForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("apartment", apartmentService.getApartmentById(id));
        model.addAttribute("apartments", apartmentService.allApartments());
        model.addAttribute("houses", houseService.allHouses());
        model.addAttribute("statuses", Arrays.asList(SaleStatus.values()));
        model.addAttribute("update", true);
        return "apart-new";
    }

    @PostMapping("apartment-update/{id}")
    public String updateApartment(@Valid ApartmentDto apartmentDto, BindingResult bindingResult, Model model) {
        apartmentService.addApartment(apartmentDto);
        if (bindingResult.hasErrors()) {
            var errorsMap = validationService.errorsMap(bindingResult);
            model.mergeAttributes(errorsMap);
            model.addAttribute("apartment", apartmentDto);
        } else {
            apartmentService.addApartment(apartmentDto);
            model.addAttribute("message", "Квартира успешно изменена");
        }
        return getUpdateApartmentForm(apartmentDto.getId(), model);
    }

    @GetMapping("apartment-delete/{id}")
    public String deleteApartment(@PathVariable("id") Integer id) {
        apartmentService.deleteApartment(id);
        return REDIRECT_ADMIN_PAGE;
    }
}
