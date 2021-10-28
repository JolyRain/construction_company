package prbd.construction_company.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import prbd.construction_company.entities.SaleStatus;

import java.util.Set;

@Getter
@Setter
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
