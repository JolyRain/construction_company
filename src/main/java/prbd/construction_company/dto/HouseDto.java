package prbd.construction_company.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
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
