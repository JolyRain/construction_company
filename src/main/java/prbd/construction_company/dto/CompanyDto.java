package prbd.construction_company.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CompanyDto {

    private int id;

    @NotEmpty(message = "Company name can't be empty")
    @Length(max = 255, message = "Company name length more than 255")
    private String name;

    @Length(max = 255, message = "Company description length more than 255")
    private String description;

    private Set<HouseDto> houses = new HashSet<>();
    private String logo;
}
