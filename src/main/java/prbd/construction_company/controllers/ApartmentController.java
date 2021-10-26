package prbd.construction_company.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import prbd.construction_company.services.ApartmentService;
import prbd.construction_company.services.CompanyService;
import prbd.construction_company.services.HouseService;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Controller
@RequestMapping("/apartments")
public class ApartmentController {

    private final ApartmentService apartmentService;
    private final HouseService houseService;
    private final CompanyService companyService;

    @GetMapping("{house_id}")
    public String houseApartments(Model model, @PathVariable String house_id) {
        try {
            var houseID = Integer.parseInt(house_id);
            var houseDto = houseService.getHouseById(houseID);
            var apartmentsFromHouse = houseDto.getApartments();
            model.addAttribute("apartments", apartmentsFromHouse);
            model.addAttribute("house", houseDto);
            return allApartments(model);
        } catch (NumberFormatException | NoSuchElementException e) {
            return "redirect:/";
        }
    }

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
        model.addAttribute("status", apartmentService.statusMap().values());

        return "apartments";
    }


}
