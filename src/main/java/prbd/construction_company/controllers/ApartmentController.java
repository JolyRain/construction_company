package prbd.construction_company.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import prbd.construction_company.entities.Apartment;
import prbd.construction_company.entities.House;
import prbd.construction_company.repositories.ApartmentRep;
import prbd.construction_company.repositories.HouseRep;

import java.util.NoSuchElementException;

@Controller("/apartments")
public class ApartmentController {

    @Autowired
    private ApartmentRep apartmentRep;

    @Autowired
    private HouseRep houseRep;

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
        Iterable<Apartment> apartments = apartmentRep.findAll();
        model.addAttribute("apartments", apartments);
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
