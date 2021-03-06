package prbd.construction_company.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import prbd.construction_company.dto.ApartmentForFilterDto;
import prbd.construction_company.service.ApartmentService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("filter")
public class FilterRestController {
    private final ApartmentService apartmentService;

    @GetMapping
    public List<ApartmentForFilterDto> getApartments() {
        return apartmentService.allApartmentsForFilter();
    }


}
