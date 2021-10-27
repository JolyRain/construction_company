package prbd.construction_company.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import prbd.construction_company.entities.SaleStatus;

import java.util.Set;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ApartmentDto {
    private int id;
    private int number;
    private HouseDto house;
    private int entranceNumber;
    private int floorNumber;
    private int roomsCount;
    private float totalArea;
    private float livingArea;
    private int price;
    private SaleStatus status;
    private Set<ClientDto> owners;
    private String layoutImg;
}
