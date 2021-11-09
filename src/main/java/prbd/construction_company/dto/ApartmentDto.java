package prbd.construction_company.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import prbd.construction_company.entity.SaleStatus;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ApartmentDto {
    private int id;

    @Positive(message = "Number must be more than 0")
    private int number;

    private HouseDto house;

    @Positive(message = "Entrance must be more than 0")
    private int entranceNumber;

    @Positive(message = "Floor must be more than 0")
    private int floorNumber;

    @Positive(message = "Rooms count must be more than 0")
    private int roomsCount;

    @Positive(message = "Total area must be more than 0")
    private float totalArea;

    @Positive(message = "Living area must be more than 0")
    private float livingArea;

    @PositiveOrZero(message = "Price must be positive")
    private int price;

    private SaleStatus status;
    private Set<ClientDto> owners = new HashSet<>();
    private String layoutImg;
}
