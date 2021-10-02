package prbd.construction_company.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import prbd.construction_company.entities.Apartment;
import prbd.construction_company.entities.House;
import prbd.construction_company.repositories.ApartmentRep;
import prbd.construction_company.repositories.CompanyRep;
import prbd.construction_company.repositories.HouseRep;
import prbd.construction_company.services.ApartmentFilter;

import java.util.List;
import java.util.NoSuchElementException;

@Controller("/apartments")
public class ApartmentController {

    private final ApartmentRep apartmentRep;
    private final HouseRep houseRep;
    private final CompanyRep companyRep;
    private final ApartmentFilter filter;

    @Autowired
    public ApartmentController(ApartmentRep apartmentRep, HouseRep houseRep, CompanyRep companyRep, ApartmentFilter filter) {
        this.apartmentRep = apartmentRep;
        this.houseRep = houseRep;
        this.companyRep = companyRep;
        this.filter = filter;
    }


    @GetMapping("/apartments/{house_id}")
    public String houseApartments(Model model, @PathVariable String house_id) {
        try {
            Integer houseID = Integer.parseInt(house_id);
            House house = houseRep.findById(houseID).get();
            Iterable<Apartment> apartmentsFromHouse = house.getApartments();
            model.addAttribute("apartments", apartmentsFromHouse);
            model.addAttribute("house", house);
            return "apartments";
        } catch (NumberFormatException | NoSuchElementException e) {
            return "redirect:/";
        }
    }

    @GetMapping("/apartments")
    public String allApartments(Model model) {
        List<Apartment> apartments = apartmentRep.findAll();
        model.addAttribute("maxRooms", filter.maxRoomsCount());
        model.addAttribute("minRooms", filter.minRoomsCount());
        model.addAttribute("maxFloor", filter.maxFloor());
        model.addAttribute("minFloor", filter.minFloor());
        model.addAttribute("minPrice", filter.minPrice());
        model.addAttribute("maxPrice", filter.maxPrice());
        model.addAttribute("apartments", apartments);
        model.addAttribute("houses", houseRep.findAll());
        model.addAttribute("companies", companyRep.findAll());
        return "apartments";
    }

//    @GetMapping("/apartments/{company}/{house}")
//    public String houseApartments(Model model,
//                                  @PathVariable(required = false) String company,
//                                  @PathVariable(required = false) String house) {
//        Iterable<Apartment> apartments = apartmentRep.findAll();
//        model.addAttribute("apartments", apartments);
//        return "apartments";
//    }

}
