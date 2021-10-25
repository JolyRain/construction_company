package prbd.construction_company.dto;


import lombok.Data;

import java.util.Set;

@Data
public class ClientDto {
    private int id;
    private String name;
    private String surname;
    private Set<ApartmentDto> apartments;
}
