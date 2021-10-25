package prbd.construction_company.dto;

import lombok.Data;
import prbd.construction_company.entities.Apartment;

import java.time.LocalDate;
import java.util.Set;

@Data
public class HouseDto {
    private int id;
    private CompanyDto company;
    private String address;
    private String name;
    private LocalDate startDate;
    private LocalDate completeDate;
    private LocalDate exploitDate;
    private Set<ApartmentDto> apartments;
    private String photo;

}
