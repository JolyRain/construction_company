package prbd.construction_company.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import prbd.construction_company.entity.SaleStatus;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ApartmentForFilterDto {
    private int id;
    private int number;
    private int entranceNumber;
    private int floorNumber;
    private int roomsCount;
    private float totalArea;
    private float livingArea;
    private int price;
    private SaleStatus status;
    private String layoutImg;
    private String houseAddress;
    private String housePhoto;
    private int companyId;
    private int houseId;
}