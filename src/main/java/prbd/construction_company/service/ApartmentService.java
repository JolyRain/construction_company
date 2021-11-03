package prbd.construction_company.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import prbd.construction_company.dto.ApartmentDto;
import prbd.construction_company.dto.ApartmentForFilterDto;
import prbd.construction_company.dto.ClientDto;
import prbd.construction_company.entity.SaleStatus;
import prbd.construction_company.exception.NotFoundException;
import prbd.construction_company.mapper.ApartmentMapper;
import prbd.construction_company.repository.ApartmentRep;
import prbd.construction_company.repository.HouseRep;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ApartmentService {
    private final ApartmentRep apartmentRep;
    private final ApartmentMapper apartmentMapper;
    private final HouseService houseService;


    public ApartmentDto addApartment(ApartmentDto apartmentDto) {
        apartmentRep.save(apartmentMapper.toEntity(apartmentDto, ApartmentMapper.CONTEXT));
        return apartmentDto;
    }

    public ApartmentDto addApartment(ApartmentDto apartmentDto, Integer houseId) {
        apartmentDto.setHouse(houseService.getHouseById(houseId));
        return addApartment(apartmentDto);
    }

    public ApartmentDto getApartmentById(Integer id) {
        return apartmentMapper.toDto(apartmentRep.findById(id)
                        .orElseThrow(() -> new NotFoundException("Apartment not found!")), ApartmentMapper.CONTEXT);
    }

    public List<ApartmentDto> allApartments() {
        return apartmentMapper.toDtoList(apartmentRep.findAll(), ApartmentMapper.CONTEXT);
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

    public Set<ApartmentDto> updateStatus(Set<ApartmentDto> apartments) {
        apartments.forEach(apartment -> {
            if (apartment.getOwners().isEmpty())
                apartment.setStatus(SaleStatus.SALE);
            addApartment(apartment);
        });
        return apartments;
    }

    public ApartmentDto addOwner(ApartmentDto apartment, ClientDto client) {
        apartment.getOwners().add(client);
        apartment.setStatus(SaleStatus.SOLD);
        return apartment;
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
