package prbd.construction_company.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
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
