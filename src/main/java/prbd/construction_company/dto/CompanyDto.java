package prbd.construction_company.dto;

import lombok.Data;

import java.util.Set;

@Data
public class CompanyDto {

    private int id;
    private String name;
    private String description;
    private Set<HouseDto> houses;
    private String logo;
}
