package prbd.construction_company.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import prbd.construction_company.services.HouseService;

import java.time.format.DateTimeFormatter;

@RequiredArgsConstructor
@Controller
@RequestMapping("house")
public class HouseController {
    private final HouseService houseService;

    @GetMapping("{id}")
    public String getHousePage(@PathVariable Integer id, Model model) {
        var houseDto = houseService.getHouseById(id);
        model.addAttribute("title", "Дом " + houseDto.getName());
        model.addAttribute("house", houseDto);
        model.addAttribute("maxPrice", houseService.getMaxApartPrice(houseDto));
        model.addAttribute("minPrice", houseService.getMinApartPrice(houseDto));
        model.addAttribute("avgPrice", houseService.getAvgPrice(houseDto));
        model.addAttribute("avgArea", houseService.getAvgArea(houseDto));

        model.addAttribute("dateFormat", DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return "house";
    }
}
