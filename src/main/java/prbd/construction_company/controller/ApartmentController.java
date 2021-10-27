package prbd.construction_company.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import prbd.construction_company.entity.SaleStatus;
import prbd.construction_company.service.ApartmentService;
import prbd.construction_company.service.CompanyService;
import prbd.construction_company.service.HouseService;

import java.util.Arrays;

@RequiredArgsConstructor
@Controller
@RequestMapping("apartments")
public class ApartmentController {

    private final ApartmentService apartmentService;
    private final HouseService houseService;
    private final CompanyService companyService;

    @GetMapping
    public String allApartments(Model model) {
        model.addAttribute("maxRooms", apartmentService.maxRoomsCount());
        model.addAttribute("minRooms", apartmentService.minRoomsCount());
        model.addAttribute("maxFloor", apartmentService.maxFloor());
        model.addAttribute("minFloor", apartmentService.minFloor());
        model.addAttribute("minPrice", apartmentService.minPrice());
        model.addAttribute("maxPrice", apartmentService.maxPrice());
        model.addAttribute("apartments", apartmentService.allApartments());
        model.addAttribute("houses", houseService.allHouses());
        model.addAttribute("companies", companyService.allCompanies());
        model.addAttribute("statuses", Arrays.asList(SaleStatus.values()));

        return "apartments";
    }


}
