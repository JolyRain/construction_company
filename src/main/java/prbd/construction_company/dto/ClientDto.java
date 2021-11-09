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
public class ClientDto {
    private int id;

    @NotEmpty(message = "Name can't be empty")
    @Length(max = 255, message = "Name length more than 255")
    private String name;

    @NotEmpty(message = "Surname can't be empty")
    @Length(max = 255, message = "Surname length more than 255")
    private String surname;

    private Set<ApartmentDto> apartments = new HashSet<>();
}
