package prbd.construction_company.dto;

import lombok.Data;
import prbd.construction_company.entities.House;

import java.util.Set;

@Data
public class CompanyDto {

    private int id;
    private String name;
    private String description;
//    private Set<House> houses;
    private String logo;
}
