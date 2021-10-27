package prbd.construction_company.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import prbd.construction_company.dto.ApartmentDto;
import prbd.construction_company.dto.HouseDto;
import prbd.construction_company.entities.Apartment;
import prbd.construction_company.entities.SaleStatus;
import prbd.construction_company.exception.NotFoundException;
import prbd.construction_company.mapper.ApartmentMapper;
import prbd.construction_company.repositories.ApartmentRep;

import java.util.*;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Service
public class ApartmentService {
    private final ApartmentRep apartmentRep;
    private final ApartmentMapper apartmentMapper;


    public ApartmentDto addApartment(ApartmentDto apartmentDto) {
        apartmentRep.save(apartmentMapper.toEntity(apartmentDto, ApartmentMapper.CONTEXT));
        return apartmentDto;
    }

    public ApartmentDto getApartmentById(Integer id) {
        return apartmentMapper
                .toDto(apartmentRep.findById(id).orElseThrow(() -> new NotFoundException()), ApartmentMapper.CONTEXT);
    }

    public List<ApartmentDto> allApartments() {
        var apartmentDtoList = new ArrayList<ApartmentDto>();

        apartmentRep.findAll().forEach(apartment ->
                apartmentDtoList.add(apartmentMapper.toDto(apartment, ApartmentMapper.CONTEXT)));
        return apartmentDtoList;
    }

    //для delete можно void
    public ApartmentDto deleteApartment(ApartmentDto apartmentDto) {
        apartmentRep.delete(apartmentMapper.toEntity(apartmentDto, ApartmentMapper.CONTEXT));
        return apartmentDto;
    }

    public ApartmentDto deleteApartment(Integer id) {
        var apartmentDto = getApartmentById(id);
        deleteApartment(apartmentDto);
        return apartmentDto;
    }

    public void updateApartment(Integer id, HouseDto houseDto, Integer number,
                                Integer floor, Integer entrance, Integer roomsCount,
                                Float totalArea, Float livingArea, Integer price,
                                SaleStatus status, String layoutImg) {
        ApartmentDto apartmentDto = getApartmentById(id);
        apartmentDto.setHouse(houseDto);
        apartmentDto.setNumber(number);
        apartmentDto.setFloorNumber(floor);
        apartmentDto.setEntranceNumber(entrance);
        apartmentDto.setRoomsCount(roomsCount);
        apartmentDto.setTotalArea(totalArea);
        apartmentDto.setLivingArea(livingArea);
        apartmentDto.setPrice(price);
        apartmentDto.setStatus(status);
        apartmentDto.setLayoutImg(layoutImg);
        addApartment(apartmentDto);
    }

    private Integer boundaryValues(ToIntFunction<ApartmentDto> attribute, Function<IntStream, OptionalInt> function) {
        var apartmentsDtoList = allApartments();
        var intStream = apartmentsDtoList.stream().mapToInt(attribute);
        var optResult = function.apply(intStream);
        return optResult.isPresent() ? optResult.getAsInt() : -1;
    }

    public Integer maxRoomsCount() {
        return boundaryValues(ApartmentDto::getRoomsCount, IntStream::max);
    }

    public Integer minRoomsCount() {
        return boundaryValues(ApartmentDto::getRoomsCount, IntStream::min);
    }

    public Integer minPrice() {
        return boundaryValues(ApartmentDto::getPrice, IntStream::min);
    }

    public Integer maxPrice() {
        return boundaryValues(ApartmentDto::getPrice, IntStream::max);
    }

    public Integer minFloor() {
        return boundaryValues(ApartmentDto::getFloorNumber, IntStream::min);
    }

    public Integer maxFloor() {
        return boundaryValues(ApartmentDto::getFloorNumber, IntStream::max);
    }

    public Map<SaleStatus, String> statusMap() {
        Map<SaleStatus, String> map = new HashMap<>();
        for (SaleStatus s : SaleStatus.values()) {
            map.put(s, s.getStatus());
        }
        return map;
    }


}
