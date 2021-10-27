package prbd.construction_company.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import prbd.construction_company.dto.ApartmentDto;
import prbd.construction_company.dto.ApartmentForFilterDto;
import prbd.construction_company.exception.NotFoundException;
import prbd.construction_company.mapper.ApartmentMapper;
import prbd.construction_company.repositories.ApartmentRep;

import java.util.List;
import java.util.stream.Collectors;

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
        return apartmentMapper.toDto(apartmentRep.findById(id)
                        .orElseThrow(() -> new NotFoundException("Apartment not found!")), ApartmentMapper.CONTEXT);
    }

    public List<ApartmentDto> allApartments() {
        return apartmentRep.findAll()
                .stream()
                .map(apartment -> apartmentMapper.toDto(apartment, ApartmentMapper.CONTEXT))
                .collect(Collectors.toList());
    }

    public List<ApartmentForFilterDto> allApartmentsForFilter() {
        return apartmentRep.findAll()
                .stream()
                .map(apartmentMapper::toDtoForFilter)
                .collect(Collectors.toList());
    }

    public void deleteApartment(ApartmentDto apartmentDto) {
        apartmentRep.delete(apartmentMapper.toEntity(apartmentDto, ApartmentMapper.CONTEXT));
    }

    public void deleteApartment(Integer id) {
        deleteApartment(getApartmentById(id));
    }

    public Integer maxRoomsCount() {
        return apartmentRep.findMaxRoomsCount();
    }

    public Integer minRoomsCount() {
        return apartmentRep.findMinRoomsCount();
    }

    public Integer minPrice() {
        return apartmentRep.findMinPrice();
    }

    public Integer maxPrice() {
        return apartmentRep.findMaxPrice();
    }

    public Integer minFloor() {
        return apartmentRep.findMinFloor();
    }

    public Integer maxFloor() {
        return apartmentRep.findMaxFloor();
    }

}
