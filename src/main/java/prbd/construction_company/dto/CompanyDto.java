package prbd.construction_company.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class CompanyDto {

    private int id;
    private String name;
    private String description;
    private Set<HouseDto> houses;
    private String logo;
}
