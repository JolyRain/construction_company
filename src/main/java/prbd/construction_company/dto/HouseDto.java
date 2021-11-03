package prbd.construction_company.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class HouseDto {
    private int id;
    private CompanyDto company;

    @NotBlank(message = "Address can't be empty")
    @Length(max = 255, message = "Address length more than 255")
    private String address;

    @NotBlank(message = "Name can't be empty")
    @Length(max = 255, message = "Name length more than 255")
    private String name;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate startDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate completeDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate exploitDate;

    private Set<ApartmentDto> apartments = new HashSet<>();
    private String photo;
}
